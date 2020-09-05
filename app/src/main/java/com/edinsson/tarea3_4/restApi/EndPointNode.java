package com.edinsson.tarea3_4.restApi;

import com.edinsson.tarea3_4.restApi.modelo.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface EndPointNode {

    @FormUrlEncoded
    @POST(ConstantesRestAPINode.KEY_POST_ID_TOKEN)
    Call<Usuario> registrarTokenID(@Field("token_device") String token_device, @Field("id_account") String id_account);

}
