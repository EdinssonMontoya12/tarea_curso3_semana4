package com.edinsson.tarea3_4.restApi.adapter;

import com.edinsson.tarea3_4.restApi.ConstantesRestApi;
import com.edinsson.tarea3_4.restApi.IMethodsApi;
import com.edinsson.tarea3_4.restApi.deserializador.CardViewMainDeserializador;
import com.edinsson.tarea3_4.restApi.modelo.CardViewReply;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapter {

    public IMethodsApi establecerConexionRestApiInstagram(Gson gson){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.HOST_INSTAGRAM)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(IMethodsApi.class);
    }

    public Gson contruyeGsonDeserializadorMedia(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(CardViewReply.class, new CardViewMainDeserializador());
        return gsonBuilder.create();
    }

}
