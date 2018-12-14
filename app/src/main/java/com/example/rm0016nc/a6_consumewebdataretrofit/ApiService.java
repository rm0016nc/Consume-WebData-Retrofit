package com.example.rm0016nc.a6_consumewebdataretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL = "https://ghibliapi.herokuapp.com/";

    @GET("films")
    Call<List<Movies>> getmNames();
}
