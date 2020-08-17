package com.edinsson.tarea3_4.modelo;

public class CardViewMain {

    private int id;
    private String picture;
    private String name;
    private int raitingNumber;

    public CardViewMain() {
    }

    public CardViewMain(String picture, String name, int likenumber) {
        this.picture = picture;
        this.name = name;
        this.raitingNumber = likenumber;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRaitingNumber() {
        return raitingNumber;
    }

    public void setRaitingNumber(int likenumber) {
        this.raitingNumber = likenumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
