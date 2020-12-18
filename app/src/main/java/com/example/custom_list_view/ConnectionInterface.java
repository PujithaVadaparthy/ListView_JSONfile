package com.example.custom_list_view;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ConnectionInterface {
    @GET("repositories")
    Call<List<Repository_List>> getRepository_list_JSON();
}
