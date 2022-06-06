package com.thelion.thegeoptapp.ui.cities;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.JsonArray;
import com.thelion.thegeoptapp.api.GeoPTService;
import com.thelion.thegeoptapp.api.ServiceProvider;
import com.thelion.thegeoptapp.utilities.GeneralUtilities;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitiesViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<List<String>> mCities;
    private ServiceProvider<GeoPTService> serviceProvider;

    public CitiesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is cities' list fragment");
        mCities = new MutableLiveData<>();

        //hardcoded. Not good
        serviceProvider = new ServiceProvider<>(GeoPTService.class);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<String>> getCities() {
        apiCallGetAllCities();
        return  mCities;
    }

    public boolean favoriteCity(String cityName) {
        //todo: save the given city to favorite list and present such list in favorite fragment
        return true;
    }

    private void apiCallGetAllCities(){
        Call<JsonArray> getAllCitiesCall = ((GeoPTService)serviceProvider.provide()).getAllCities();
        getAllCitiesCall.enqueue(new Callback<JsonArray>() {

            @Override
            public void onResponse(@NotNull Call<JsonArray> call, @NotNull Response<JsonArray> response) {
                //Log.d("RESPONSE API ALL CITIES TEST: ", new Gson().toJson(response.body()));
                JsonArray apiResponseCities = response.body().getAsJsonArray();

                mCities.setValue(GeneralUtilities.fromJsonArrayToListString(apiResponseCities));
            }

            @Override
            public void onFailure(@NotNull Call<JsonArray> call, @NotNull Throwable t) {
                Log.e("API Call error: ", t.getMessage());
            }
        });
    }
}