package com.prady.adda247task;

import com.prady.adda247task.jsontopojo.Adda247;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("users")
    Call<Adda247> getDetails();
}
