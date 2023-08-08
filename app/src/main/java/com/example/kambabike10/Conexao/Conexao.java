package com.example.kambabike10.Conexao;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public  class  Conexao extends AsyncTask<Void, Void, String> {
    public static String URL_1="";
    public static  String  Action="";

    public Conexao(String path, String Method){
        Action=Method;
        URL_1=path;
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            return NewConexao2();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static Object NewConexao(String caminho) throws IOException {
        URL_1="https://api.funtranslations.com/translate/pirate.json?text=Hello%20sir%21%20my%20mother%20goes%20with%20me%20to%20the%20ocean";
        String Resultado="";
        URL api = new URL(URL_1);
        int codigoConexão;
        HttpURLConnection conexao;
        InputStream is;

        conexao=(HttpURLConnection) api.openConnection();
        conexao.setRequestMethod("GET");
        conexao.setReadTimeout(150000);
        conexao.setConnectTimeout(15000);
        conexao.connect();

        codigoConexão=conexao.getResponseCode();
        if(codigoConexão<HttpURLConnection.HTTP_BAD_REQUEST){
            is= conexao.getInputStream();

        }else{
            is=conexao.getErrorStream();
        }

        Resultado=converterInputStreamToString(is);
        is.close();
        conexao.disconnect();

        return Resultado;
    }
    private static String converterInputStreamToString(InputStream is){
        StringBuffer buffer = new StringBuffer();
        try{
            BufferedReader br;
            String linha;

            br = new BufferedReader(new InputStreamReader(is));
            while((linha = br.readLine())!=null){
                buffer.append(linha);
            }

            br.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return buffer.toString();
    }

    public static String NewConexao2() throws IOException {
        StringBuilder resposta = new StringBuilder();
        // if omitido

        try {
            URL url = new URL(URL_1);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(Action.toUpperCase());
            connection.setRequestProperty("Content-type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            connection.setDoOutput(true);
            connection.setRequestProperty("login","p@test56");
            connection.setRequestProperty("senha","123");
            connection.setConnectTimeout(5000);
            //BasicHttpParams body=new BasicHttpParams();

            Scanner scanner = new Scanner(url.openStream());
            while (scanner.hasNext()) {
                resposta.append(scanner.next());}
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //new Gson().fromJson(resposta.toString(), CEP.class);
        return resposta.toString();
    }
}
