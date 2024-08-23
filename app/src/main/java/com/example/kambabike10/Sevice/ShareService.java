package com.example.kambabike10.Sevice;

import com.example.kambabike10.Dto.DocaDto;
import com.example.kambabike10.Dto.DocaDto2;
import com.example.kambabike10.Dto.ShareDto;
import com.example.kambabike10.Dto.UsuarioDto;
import com.example.kambabike10.Model.Share;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ShareService {

    @GET("share/all")
    Call<List<Share>> SharList();
    @GET("share/lastbyuser/{id}")
    Call<Share> GetLastShare(@Path("id") String id);
    @POST("share")
    Call<Object>  SaveShare(@Body ShareDto dado);
    @PUT("share/update/{id}")
    Call<Object> UpdateShare(@Path("id") int id, @Body ShareDto dado);
}
