package com.example.desafiopreguntadinamica2303.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

  private static Retrofit retrofit; //crea retrofit
    private static final String BASE_URL = "https://opentdb.com/";

    public static Retrofit getRetrofit (){  // OBTENER Y CONVERTR DATOS RETROFIT
        if (retrofit==null){
            retrofit = new retrofit2.Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
