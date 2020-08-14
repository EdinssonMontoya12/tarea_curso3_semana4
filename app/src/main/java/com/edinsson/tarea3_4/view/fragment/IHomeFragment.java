package com.edinsson.tarea3_4.view.fragment;

import com.edinsson.tarea3_4.modelo.CardViewMain;

import java.util.ArrayList;

public interface IHomeFragment {

    public void generarLinearLayoutVertical();

    public void generarAdaptadorRecyclerView(ArrayList<CardViewMain> usuarios);
}
