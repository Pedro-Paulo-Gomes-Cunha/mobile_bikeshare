package com.example.kambabike10.Controller;

import com.example.kambabike10.Conexao.Conexao;
import com.example.kambabike10.Dto.Login;
import com.example.kambabike10.Helpers.Principal;

import java.util.concurrent.ExecutionException;

public class UsuarioController {
    public String Logar(/*String Email, String Senha*/) throws ExecutionException, InterruptedException {



           String t= new Conexao(Principal.get_Principal().getUrlGeral()+"/usuario/login?login=p@test56&senha=123","get").execute().get().toString();

          //  Usuario doo= new Gson().fromJson(t, Usuario.class)

        return  t;
    }

    public /*Usuario*/ String Add(/*String Email, String Senha*/) throws ExecutionException, InterruptedException {

        Login dados =new Login();


        String req =Principal.get_Principal().getUrlGeral()+"/1";


        String t= new Conexao(Principal.get_Principal().getUrlGeral()+"/usuario/login?login=p@test56&senha=123","get").execute().get();

        //  new Gson().fromJson(t, Usuario.class);

        return  t;
    }
}
