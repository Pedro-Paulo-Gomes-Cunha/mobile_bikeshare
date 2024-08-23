package com.example.kambabike10.Sevice;

import com.example.kambabike10.Dto.DocaDto;
import com.example.kambabike10.Dto.DocaDto2;
import com.example.kambabike10.Dto.UsuarioDto;
import com.example.kambabike10.Model.Doca;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface DocaService {

    @GET("doca/all")
    Call<List<DocaDto2>> DocaList();

    @GET("doca/findbynome/{id}")
    Call<DocaDto2> GetVerify(@Path("nome") String nome);

    @PUT("doca/update/{id}")
    Call<Object> UpdateDoca(@Path("id") String id, @Body DocaDto dado);

}
