package com.edinsson.tarea3_4.modelo;

public class CardViewMain {

    private String id;
    private String picture;
    private String name;
    private String raitingNumber;

    public CardViewMain(String picture, String name, String likenumber) {
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

    public String getRaitingNumber() {
        return raitingNumber;
    }

    public void setRaitingNumber(String likenumber) {
        this.raitingNumber = likenumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
