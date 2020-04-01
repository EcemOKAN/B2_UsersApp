package com.ecemokan.usersapp.model;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface UsersApi {
    @GET("users")
    Single<List<UserModel>> getUsers();

}
