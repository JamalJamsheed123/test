package com.example.codingtestmjamal.Services;

import com.example.codingtestmjamal.Model.Users;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("/api/v1/users")
    Call< List< Users > > getUsersLists();

    @POST("/api/v1/users")
    Call<Users> addUser(@Body Users user);
}
