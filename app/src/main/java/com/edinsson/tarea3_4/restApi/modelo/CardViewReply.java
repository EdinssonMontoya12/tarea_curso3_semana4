package com.edinsson.tarea3_4.restApi.modelo;

import androidx.cardview.widget.CardView;

import com.edinsson.tarea3_4.modelo.CardViewMain;

import java.util.ArrayList;

public class CardViewReply {

    ArrayList<CardViewMain> cardViews = new ArrayList<>();

    public ArrayList<CardViewMain> getCardViews() {
        return cardViews;
    }

    public void setCardViews(ArrayList<CardViewMain> cardViews) {
        this.cardViews = cardViews;
    }
}
