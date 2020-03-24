package com.example.desafiopreguntadinamica2303.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RespuestaApi {

    @SerializedName("response_code")
    private int responseCode;

    @SerializedName("results")
    private List<Result> results;


    //GETTER Y SETTER

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}
