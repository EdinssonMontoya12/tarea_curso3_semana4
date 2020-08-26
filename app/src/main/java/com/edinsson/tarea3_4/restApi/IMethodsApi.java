package com.edinsson.tarea3_4.restApi;

import com.edinsson.tarea3_4.restApi.modelo.CardViewReply;

import retrofit2.Call;
import retrofit2.http.GET;

public interface IMethodsApi {

    @GET(ConstantesRestApi.GET_ALL_MEDIA_INFO)
    public Call<CardViewReply> getAllMediaInfo();

}
