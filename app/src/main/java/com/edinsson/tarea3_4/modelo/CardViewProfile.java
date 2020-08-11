package com.edinsson.tarea3_4.modelo;

public class CardViewProfile {

    private String image;
    private String raitingNumber;

    public CardViewProfile(String image, String raitingNumber) {
        this.image = image;
        this.raitingNumber = raitingNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRaitingNumber() {
        return raitingNumber;
    }

    public void setRaitingNumber(String raitingNumber) {
        this.raitingNumber = raitingNumber;
    }
}
