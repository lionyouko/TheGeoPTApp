package com.thelion.thegeoptapp.utilities;

import android.util.Log;

import com.google.gson.JsonObject;
import com.thelion.thegeoptapp.api.GeoPTService;
import com.thelion.thegeoptapp.api.ServiceProvider;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Class under construction. It needs to centralize the api calls using service provider.
 * Must take a look how to get the right response from onResponse in the queue, because the apiCallSOMETHING needs to return what was asked
 * And the response will be inside the queue (see how response is enqueued using Callback).
 */
public class APICaller {

    public APICaller(){}

    public void apiCallGetACity(ServiceProvider<GeoPTService> serviceProvider, String cityName){
        Call<JsonObject> getACityCall = ((GeoPTService)serviceProvider.provide()).getACity(cityName);
        getACityCall.enqueue(new Callback<JsonObject>() {

            @Override
            public void onResponse(@NotNull Call<JsonObject> call, @NotNull Response<JsonObject> response) {
                //Log.d("RESPONSE API ALL CITIES TEST: ", new Gson().toJson(response.body()));
                JsonObject apiResponseCity = response.body().getAsJsonObject();
                //TODO: open new activity showing the info of the city
                Log.d("CITY TEST", apiResponseCity.toString());

            }
            @Override
            public void onFailure(@NotNull Call<JsonObject> call, @NotNull Throwable t) {
                Log.e("API Call error: ", t.getMessage());
            }
        });
    }
}
