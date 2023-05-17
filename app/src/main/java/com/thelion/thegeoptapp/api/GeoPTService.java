package com.thelion.thegeoptapp.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface GeoPTService {

    @Headers({
            GeoPTServiceGenerator.H_ACCEPT_JSON,
            GeoPTServiceGenerator.H_USER_AGENT
    })
    @GET("/municipios")
    Call<JsonArray> getAllCities();


    @Headers({
            GeoPTServiceGenerator.H_ACCEPT_JSON,
            GeoPTServiceGenerator.H_USER_AGENT
    })
    @GET("/municipios/{city}")
    Call<JsonObject> getACity(@Path("city") String city);


    @Headers({
            GeoPTServiceGenerator.H_ACCEPT_JSON,
            GeoPTServiceGenerator.H_USER_AGENT
    })
    @GET("/municipios/{city}/freguesias")
    Call<JsonObject> getAParishesOfACity(@Path("city") String city);
}
