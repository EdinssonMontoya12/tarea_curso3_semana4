package com.edinsson.tarea3_4.adapter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edinsson.tarea3_4.R;
import com.edinsson.tarea3_4.db.ConstantesBaseDatos;
import com.edinsson.tarea3_4.db.ConstructorCardViewMain;
import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.edinsson.tarea3_4.restApi.EndPointNode;
import com.edinsson.tarea3_4.restApi.adapter.RestApiAdapterNode;
import com.edinsson.tarea3_4.restApi.modelo.Usuario;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PictureMainRecyclerViewAdapter extends RecyclerView.Adapter<PictureMainRecyclerViewAdapter.PictureViewHolder> {

    private ArrayList<CardViewMain> pictures;
    private int resource;
    private Activity activity;

    public PictureMainRecyclerViewAdapter(ArrayList<CardViewMain> pictures, int resource, Activity activity) {
        this.pictures = pictures;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PictureViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PictureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PictureViewHolder holder, int position) {
        //ConstructorCardViewMain constructorCardViewMain = new ConstructorCardViewMain(activity);
        final CardViewMain cardViewMain = pictures.get(position);
        //holder.name.setText(cardViewMain.getName());
        holder.username.setText(cardViewMain.getName());
        Picasso.get().load(cardViewMain.getPicture()).into(holder.imageView);

        holder.raiting.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                //ConstructorCardViewMain constructorCardViewMain = new ConstructorCardViewMain(activity);
                if(b) {
                    RestApiAdapterNode restApiAdapterNode = new RestApiAdapterNode();
                    EndPointNode endPointNode = restApiAdapterNode.establecerConexionRestAPI();
                    SharedPreferences sharedPreferences = activity.getSharedPreferences("usuario", activity.MODE_PRIVATE);
                    Call<Usuario> usuarioCall = endPointNode.like(cardViewMain.getName(), sharedPreferences.getString("nombre_usuario", ""));

                    usuarioCall.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            Usuario usuario = response.body();

                            Log.d("ID_USER", usuario.getIdCount());
                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {

                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class PictureViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        //private TextView name;
        private TextView username;
        private CheckBox raiting;

        public PictureViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView) itemView.findViewById(R.id.image_cardview_instagram);
            //name = (TextView) itemView.findViewById(R.id.name_pet);
            username = (TextView) itemView.findViewById(R.id.username_instagram);
            raiting = (CheckBox) itemView.findViewById(R.id.raiting_click);
        }
    }

}
