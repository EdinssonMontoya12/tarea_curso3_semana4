package com.edinsson.tarea3_4.presentador;

import android.content.Context;

import com.edinsson.tarea3_4.db.ConstructorCardViewMain;
import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.edinsson.tarea3_4.view.fragment.IHomeFragment;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IHomeFragmentPresenter{

    private IHomeFragment iHomeFragment;
    private Context context;
    private ConstructorCardViewMain constructorCardViewMain;
    ArrayList<CardViewMain> cardViewMains;

    public HomeFragmentPresenter(IHomeFragment iHomeFragment, Context context) {
        this.iHomeFragment = iHomeFragment;
        this.context = context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorCardViewMain = new ConstructorCardViewMain(context);
        cardViewMains = constructorCardViewMain.obtenerDatos();
        mostrarContactosRecyclerView();
    }

    @Override
    public void mostrarContactosRecyclerView() {
        iHomeFragment.generarAdaptadorRecyclerView(cardViewMains);
        iHomeFragment.generarLinearLayoutVertical();
    }
}
