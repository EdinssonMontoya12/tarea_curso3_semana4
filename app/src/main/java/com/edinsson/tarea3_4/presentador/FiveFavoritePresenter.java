package com.edinsson.tarea3_4.presentador;

import android.content.ContentValues;
import android.content.Context;

import com.edinsson.tarea3_4.db.ConstructorCardViewMain;
import com.edinsson.tarea3_4.modelo.CardViewMain;
import com.edinsson.tarea3_4.view.IFiveFavorite;

import java.util.ArrayList;

public class FiveFavoritePresenter implements IFiveFavoritePresenter {

    private IFiveFavorite iFiveFavorite;
    private Context context;
    private ArrayList<CardViewMain> cardViewMains;
    private ConstructorCardViewMain constructorCardViewMain;

    public FiveFavoritePresenter(IFiveFavorite iFiveFavorite, Context context) {
        this.iFiveFavorite = iFiveFavorite;
        this.context = context;
        obtenerContactosBaseDatos();
    }


    @Override
    public void obtenerContactosBaseDatos() {
        constructorCardViewMain = new ConstructorCardViewMain(context);
        cardViewMains = constructorCardViewMain.getFiveFavorite();
        mostrarContactosRecyclerView();
    }

    @Override
    public void mostrarContactosRecyclerView() {
        iFiveFavorite.generarLinearLayoutVertical();
        iFiveFavorite.generarAdaptadorRecyclerView(cardViewMains);
    }
}
