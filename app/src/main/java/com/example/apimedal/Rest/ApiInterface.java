package com.example.apimedal.Rest;

import com.example.apimedal.Model.GetMedal;
import com.example.apimedal.Model.PostPutDelMedal;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("medal_android")
    Call<GetMedal> getMedal();

    @FormUrlEncoded
    @POST("medal_android")
    Call<PostPutDelMedal> postMedal(@Field("Negara") String negara, @Field("gold") String gold, @Field("silver") String silver, @Field("bronze") String bronze);

    @FormUrlEncoded
    @PUT("medal_android")
    Call<PostPutDelMedal> putMedal(@Field("id") String id, @Field("Negara") String negara, @Field("gold") String gold, @Field("silver") String silver, @Field("bronze") String bronze);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "medal_android", hasBody = true)
    Call<PostPutDelMedal> deleteMedal(@Field("id") String id);
}
