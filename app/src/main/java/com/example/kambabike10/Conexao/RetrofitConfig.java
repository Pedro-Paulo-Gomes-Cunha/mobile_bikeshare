package com.example.kambabike10.Conexao;

import com.example.kambabike10.Sevice.DocaService;
import com.example.kambabike10.Sevice.ShareService;
import com.example.kambabike10.Sevice.UserService;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {


    private final Retrofit retrofit1;

    public RetrofitConfig() {
        this.retrofit1 = new Retrofit.Builder()
                .baseUrl("http://192.168.159.83:8041/")
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }

    public UserService GetUserService() {
        return this.retrofit1.create(UserService.class);
    }

    public DocaService GetDocaService(){ return this.retrofit1.create(DocaService.class);}

    public ShareService GetShareService(){ return this.retrofit1.create(ShareService.class);}

}
