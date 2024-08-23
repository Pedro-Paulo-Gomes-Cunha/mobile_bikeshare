package com.example.kambabike10.Sevice;

import android.os.AsyncTask;
import android.util.JsonReader;


import com.example.kambabike10.Conexao.Conexao;
import com.example.kambabike10.Dto.Login;
import com.example.kambabike10.Dto.UsuarioDto;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.Model.Usuario;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.net.ssl.HttpsURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface UserService {

    @GET("usuario/{id}")
    Call<Usuario> BuscarUser(@Path("id") String id);

    @GET("usuario/all")
    Call<Usuario> GetAll();

   // @FormUrlEncoded
   @GET("usuario/login/{login}/{senha}")
    Call<Usuario> GetLogin(@Path("login") String login,@Path("senha") String senha);

    @FormUrlEncoded
    @POST("usuario/")
    Call<Object>  SaveUser1(@Field("nome") String nome,
                           @Field("login") String login,
                           @Field("senha") String senha,
                           @Field("perfil") String perfil);

    @POST("usuario")
    Call<Object>  SaveUser(@Body UsuarioDto dado);

    @PUT("usuario/update/{id}")
    Call<Object> UpdateUser(@Path("id") String id,@Body UsuarioDto dado);

    @GET("usuario/{id}/{id1}")
    Call<Usuario> BuscarUser1(@Path("id") String id1, @Path("id1") String id);


}
