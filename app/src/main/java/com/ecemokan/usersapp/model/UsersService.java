package com.ecemokan.usersapp.model;

import com.ecemokan.usersapp.viewmodel.ListViewModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class UsersService {

    private static final String BASE_URL="https://api.github.com/";

    private static UsersService instance;
    private UsersApi api = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(UsersApi.class);

    private UsersService(){

    }

    public static UsersService getInstance(){
        if(instance == null)
        {
            instance= new UsersService();
        }
        return instance;
    }

    public Single<List<UserModel>> getUsers(){
        return api.getUsers();
    }
}
