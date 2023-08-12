package com.example.kambabike10.Helpers;

import android.app.Application;

import com.example.kambabike10.Model.Usuario;

public class Principal{// extends Application {

    private static Principal _Principal;
     // public static  Usuario  user=new Usuario();Principalcomocomo,j
      private static  String teste;

    public static String getUrlGeral() {
        return UrlGeral;
    }

    public static void setUrlGeral(String urlGeral) {
        UrlGeral = urlGeral;
    }

    private static  String UrlGeral="https//ebd8-102-214-36-48.ngrok.io";

    public synchronized  static Principal get_Principal() {
        if(_Principal==null){
            teste=null;
            _Principal= new Principal();
        }
        return _Principal;
    }

    public static String getTeste() {
  return teste;
 }

 public static void setTeste(String teste1) {
  Principal.teste = teste1;
 }


}
