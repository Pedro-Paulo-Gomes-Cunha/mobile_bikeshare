package com.example.kambabike10.Conexao;

import com.example.kambabike10.Sevice.UserService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class ApiClient {
    private final Retrofit retrofit1;

    public ApiClient() {

       HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        this.retrofit1 = new Retrofit.Builder()
                .baseUrl("http://192.168.1.11:8040/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }


    public UserService GetUserService() {
        return this.retrofit1.create(UserService.class);
    }


}
