package com.thelion.thegeoptapp.api;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GeoPTServiceGenerator {
    private static final String BASE_URL = "https://geoapi.pt";
    public static final String H_USER_AGENT = "User-Agent: Mozzarela FireFuxy";
    public static final String H_ACCEPT_JSON = "Accept: application/json";

    private static OkHttpClient httpClient =
            new OkHttpClient.Builder().build();

    private static final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    private static final Retrofit retrofit = builder.client(httpClient).build();

    public static <S> S createService(
            Class<S> serviceClass) {
        return retrofit.create(serviceClass);
    }

}
