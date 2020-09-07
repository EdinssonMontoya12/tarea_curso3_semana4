package com.edinsson.tarea3_4.restApi.modelo;

public class Usuario {

    private String token_device;
    private String id_account;

    public Usuario() {
    }

    public Usuario(String token_device, String id_account) {
        this.token_device = token_device;
        this.id_account = id_account;
    }

    public String getToken() {
        return token_device;
    }

    public void setToken(String token) {
        this.token_device = token;
    }

    public String getIdCount() {
        return id_account;
    }

    public void setIdCount(String idCount) {
        this.id_account = idCount;
    }

}
