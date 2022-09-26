package com.rony.sms.Api;

import com.rony.sms.Model.CostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("api/cost")
    Call<List<CostModel>> getCost();

    @FormUrlEncoded
    @POST("api/cost")
    Call<CostModel> addCost(
            @Field("reason") String reason,
            @Field("amount") String amount
    );

}
