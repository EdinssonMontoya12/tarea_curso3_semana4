package com.edinsson.tarea3_4.restApi.modelo;

public class Usuario {

    private String id;
    private String token_device;
    private String id_account;

    public Usuario() {
    }

    public Usuario(String id, String token_device, String id_account) {
        this.id = id;
        this.token_device = token_device;
        this.id_account = id_account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
