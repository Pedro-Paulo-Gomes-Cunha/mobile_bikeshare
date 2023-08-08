package com.example.kambabike10.Controller;

import android.util.JsonReader;

import com.example.kambabike10.Conexao.Conexao;
import com.example.kambabike10.Dto.Login;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.Model.Usuario;

import java.util.concurrent.ExecutionException;

public class UsuarioController {
    private Usuario Logar(String Email, String Senha) throws ExecutionException, InterruptedException {

        Login dados =new Login();
        dados.setLogin(Email);
        dados.setSenha(Senha);

       String req =Principal.get_Principal().getUrlGeral()+"/1"


           String t= new Conexao(Principal.get_Principal().getUrlGeral()+"/login","get").execute().get();

        t.Js

        return  new Gson().fromJson(t, Usuario.class);;
    }
}
