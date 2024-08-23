package com.example.kambabike10.Helpers;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import com.example.kambabike10.Conexao.RetrofitConfig;
import com.example.kambabike10.Dto.DocaDto2;
import com.example.kambabike10.Dto.ShareDto;
import com.example.kambabike10.MainActivity;
import com.example.kambabike10.Model.Doca;
import com.example.kambabike10.Model.Share;
import com.example.kambabike10.Model.Usuario;
import com.example.kambabike10.cadastrar;
import com.example.kambabike10.dasboard;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Principal{// extends Application {

    private static Principal _Principal;
     // public static  Usuario  user=new Usuario();Principalcomocomo,j
      private static  String teste;

    private static  boolean  control;

    private static  boolean  btnClick;

    public static String getUrlGeral() {
        return UrlGeral;
    }

    public static DocaDto2 doca;

    public static Context context;
    public static List<DocaDto2> docas;

    public static Intent intent;



    public static Usuario UserDados;

    public static boolean isControl() {
        return control;
    }

    public static void setControl(boolean control) {
        Principal.control = control;
    }

    public static void setUrlGeral(String urlGeral) {
        UrlGeral = urlGeral;
    }

    private static  String UrlGeral="https://7bd0-102-214-36-182.ngrok.io";

    public synchronized  static Principal get_Principal() {
        if(_Principal==null){
            teste=null;
            control=false;
            doca=new DocaDto2();
            docas =new ArrayList();
            UserDados=new Usuario();
            context=null;
            intent=null;
            _Principal= new Principal();
        }
        return _Principal;
    }

    public static Intent getIntent() {
        return intent;
    }

    public static void setIntent(Intent intent) {
        Principal.intent = intent;
    }

    public static List<DocaDto2> getDocas() {
        return docas;
    }

    public static Context getContext() {
        return context;
    }

    public static void setContext(Context context) {
        Principal.context = context;
    }

    public static void setDocas(List<DocaDto2> docas) {
        Principal.docas = docas;
    }

    public static String getTeste() {
  return teste;
 }

    public static Usuario getUserDados() {
        return UserDados;
    }

    public static void setUserDados(Usuario userDados) {
        UserDados = userDados;
    }

    public static void setTeste(String teste1) {
  Principal.teste = teste1;
 }

    public static DocaDto2 getDoca() {
        return doca;
    }

    public static void setDoca(DocaDto2 doca) {
        Principal.doca = doca;
    }

    public static boolean LevantarBike(DocaDto2 dados){

        //Verificar se o cliente já levantou uma bike
        //Pegar o Id do Cliente e enviar pra o serviço de partilhas
        final boolean[] verificar = {true};
        if(getUserDados().getSaldo()>1){

            //Verificar se o cliente tem saldo suficiente pra levantar a bike
            //Pegar o saldo local do cliente, transformar em inteiro e validar se é sufiente


            //Registrar o levantamento
            //criar um objecto do tipo share e enviar para o serviço

            try {
                Call<Object> call = new RetrofitConfig().GetShareService().SaveShare(new ShareDto(getUserDados().getId(), dados.getId(),0,0,1));
                call.enqueue(new Callback<Object>() {
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {
                        try {
                            int codigo= response.code();
                            if (codigo==201) {
                              //  Toast.makeText(getContext(), "Concluido com Sucesso", Toast.LENGTH_SHORT).show();
                                setTeste("sucesso");
                            } else {
                                Toast.makeText(getContext(), "Falha no levantamento " + codigo, Toast.LENGTH_SHORT).show();
                                setTeste("Error 1");

                                Principal.setControl(false);

                            }

                        } catch (Exception e) {
                            Log.d("Exception", e.toString());
                            setTeste("Error 2");
                            Principal.setControl(false);
                        }

                    }

                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {
                        setTeste("Error 3");
                        Principal.setControl(false);
                    }


                });

            }catch (Exception e){
                Toast.makeText(getContext(), e.toString(), Toast.LENGTH_LONG).show();
                Principal.setControl(false);
                setTeste("Error 4");
            }


            //fazer o desconto ao cliente
            //pegar o o saldo local do cliente, subtrair, e fazer o update remoto e local

            Double saldo =Principal.getUserDados().getSaldo()-1;
            Principal.getUserDados().setSaldo(saldo);
            AlterSaldoCliente();


            //mudar o estado da doca
            //Enviando o id da doca e o novo estado da mesma.
            dados.setStatus(0);
            AlterStatusDoca(dados);


        }else return false;


        return true;

    }




    public static void DevolverBike(DocaDto2 dados){
        //Parametro Id da Doca

            Call<Share> call1 = new RetrofitConfig().GetShareService().GetLastShare(String.valueOf(Principal.getUserDados().Id));
            call1.enqueue(new Callback<Share>() {
                              @Override
                              public void onResponse(Call<Share> call, Response<Share> response) {

                                 Share share_ =(Share) response.body();
                                  assert share_ != null;

                                    share_.setDocaDestinoId(dados.getId());
                                    share_.setStatus(0);
                                    FecharPartilha(share_);

                              }

                              @Override
                              public void onFailure(Call<Share> call, Throwable t) {
                                  setTeste(t.getMessage());

                              }
                          });

        dados.setStatus(1);
        AlterStatusDoca(dados);

        Double saldo =Principal.getUserDados().getSaldo()+Double.valueOf(dados.getPremio());
        Principal.getUserDados().setSaldo(saldo);
        AlterSaldoCliente();

    }


    public static void AlterSaldoCliente(){
    try {

        Call<Object> call = new RetrofitConfig().GetUserService().UpdateUser(String.valueOf(Principal.getUserDados().Id), Principal.getUserDados().ToDto());

        call.enqueue(new Callback<Object>() {

            /**
             * @param call
             * @param response
             */
            @Override
            public void onResponse(Call<Object> call, Response<Object> response) {

            }

            /**
             * @param call
             * @param t
             */
            @Override
            public void onFailure(Call<Object> call, Throwable t) {

            }
        });
    }catch (Exception e){

    }


    }
    public static void AlterStatusDoca(DocaDto2 dados){

            try {

                Call<Object> call = new RetrofitConfig().GetDocaService().UpdateDoca(String.valueOf(dados.getId()), dados.ToDto());
                call.enqueue(new Callback<Object>() {

                    /**
                     * @param call
                     * @param response
                     */
                    @Override
                    public void onResponse(Call<Object> call, Response<Object> response) {

                    }

                    /**
                     * @param call
                     * @param t
                     */
                    @Override
                    public void onFailure(Call<Object> call, Throwable t) {

                    }
                });
                }catch (Exception e){

                }


    }

    public static void FecharPartilha(Share dado){

        try {

            Call<Object> call = new RetrofitConfig().GetShareService().UpdateShare(dado.getId(),dado.ToDto());
            call.enqueue(new Callback<Object>() {

                /**
                 * @param call
                 * @param response
                 */
                @Override
                public void onResponse(Call<Object> call, Response<Object> response) {

                    int codigo= response.code();
                    if (codigo!=201) {
                        setTeste(String.valueOf(codigo));
                        Toast.makeText(getContext(), "Erro 2 - " +codigo, Toast.LENGTH_SHORT).show();
                    }
                   // Object share_ = response.body();
                  //  assert share_ != null;
                }
                /**
                 * @param call
                 * @param t
                 */
                @Override
                public void onFailure(Call<Object> call, Throwable t) {
                    setTeste(t.getMessage());
                    Toast.makeText(getContext(), "Erro 2 - " +t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){

            setTeste(e.getMessage());
            Toast.makeText(getContext(), "Erro 3 - " +e.getMessage(), Toast.LENGTH_SHORT).show();

        }


    }


}
