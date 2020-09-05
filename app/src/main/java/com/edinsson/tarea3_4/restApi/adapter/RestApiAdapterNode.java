package com.edinsson.tarea3_4.restApi.adapter;

import com.edinsson.tarea3_4.restApi.ConstantesRestAPINode;
import com.edinsson.tarea3_4.restApi.EndPointNode;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestApiAdapterNode {

    public EndPointNode establecerConexionRestAPI(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestAPINode.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndPointNode.class);

    }

}
