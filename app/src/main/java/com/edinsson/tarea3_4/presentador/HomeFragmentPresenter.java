package com.edinsson.tarea3_4.presentador;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.edinsson.tarea3_4.db.ConstructorCardViewMain;
import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.edinsson.tarea3_4.restApi.IMethodsApi;
import com.edinsson.tarea3_4.restApi.adapter.RestApiAdapter;
import com.edinsson.tarea3_4.restApi.modelo.CardViewReply;
import com.edinsson.tarea3_4.view.fragment.IHomeFragment;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragmentPresenter implements IHomeFragmentPresenter{

    private IHomeFragment iHomeFragment;
    private Context context;
    private ConstructorCardViewMain constructorCardViewMain;
    ArrayList<CardViewMain> cardViewMains;

    public HomeFragmentPresenter(IHomeFragment iHomeFragment, Context context) {
        this.iHomeFragment = iHomeFragment;
        this.context = context;
        //obtenerContactosBaseDatos();
        obtenerAllMediaInfo();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorCardViewMain = new ConstructorCardViewMain(context);
        cardViewMains = constructorCardViewMain.obtenerDatos();
        mostrarContactosRecyclerView();
    }

    @Override
    public void obtenerAllMediaInfo() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gson = restApiAdapter.contruyeGsonDeserializadorMedia();
        IMethodsApi iMethodsApi = restApiAdapter.establecerConexionRestApiInstagram(gson);
        SharedPreferences data = context.getSharedPreferences("usuario", context.MODE_PRIVATE);
        Call<CardViewReply> cardViewReplyCall;
        if(data.getString("nombre_usuario", "").equals("pepe58632145975224")) {
            cardViewReplyCall = iMethodsApi.getAllMediaInfoJuan();
        }else{
            cardViewReplyCall = iMethodsApi.getAllMediaInfo();
        }

        cardViewReplyCall.enqueue(new Callback<CardViewReply>() {
            @Override
            public void onResponse(Call<CardViewReply> call, Response<CardViewReply> response) {
                CardViewReply cardViewReply = response.body();
                cardViewMains = cardViewReply.getCardViews();
                mostrarContactosRecyclerView();
            }

            @Override
            public void onFailure(Call<CardViewReply> call, Throwable t) {
                Toast.makeText(context, "Algo falló", Toast.LENGTH_SHORT).show();
                Log.e("Falló la conexion", t.toString());
            }
        });
    }

    @Override
    public void mostrarContactosRecyclerView() {
        iHomeFragment.generarAdaptadorRecyclerView(cardViewMains);
        iHomeFragment.generarLinearLayoutVertical();
    }
}
