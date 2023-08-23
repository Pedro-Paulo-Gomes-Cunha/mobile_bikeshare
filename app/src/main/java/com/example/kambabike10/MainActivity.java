package com.example.kambabike10;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kambabike10.Conexao.Conexao;
import com.example.kambabike10.Conexao.RetrofitConfig;
import com.example.kambabike10.Controller.UsuarioController;
import com.example.kambabike10.Dto.Login;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.Model.Usuario;
import com.example.kambabike10.Sevice.UserService;

import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    private TextView logup,TextFails;
    private Button logar;
    EditText TextEmail, TextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Inializando a interação da tela cadastro com a tela de login
        Iniciar();
        SharedPreferences pref= getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
        if(pref.contains("UserEmail")){
          //  this.TextEmail.setText(pref.getString("UserEmail", ""));
        }



        logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent1= new Intent(MainActivity.this,cadastrar.class);
                startActivity(intent1);
            }
        });

        this.logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String d= null;
               /* try {
                    d = new Conexao("http://localhost/usuario/2","Get").execute().get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                try{
                    Login dado=new Login("p@test56","123");
                Call<Usuario> call = new RetrofitConfig().GetUserService().GetLogin(dado);
                call.enqueue(new Callback<Usuario>() {
                    @Override
                    public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                        Usuario cep = response.body();
                        assert cep != null;
                        TextEmail.setText(cep.getNome());
                        TextFails.setText("cep.toString()");
                    }

                    @Override
                    public void onFailure(Call<Usuario> call, Throwable t) {
                        Log.e("UsuarioService   ", "Erro ao buscar o Usuario:" + t.getMessage());

                       TextEmail.setText("errrro: "+t.getMessage());
                    }
                });

                }catch (Exception e){

                    TextFails.setText(e.getMessage());
                    TextEmail.setText(e.getMessage());
                }


                /////Principal.get_Principal().setTeste("dgdg");

                SharedPreferences pref= getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                //UserEmail, UserId, UserName



               // String text1= TextEmail.getText().toString();
               /* if(text1.isEmpty()){
                    TextFails.setText("Digite Seu Email");
                    return;
                }
                String text2= TextPassword.getText().toString();
                if(text2.isEmpty()){
                    TextFails.setText("Digite a Senha");
                    return;
                }*/
             /*   UserService _userService=new UserService();
                String res="";
                Usuario dados=null;
                        try {
                             res=_userService.Logar(text1,text2);
                        } catch (ExecutionException e) {
                            throw new RuntimeException(e);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                if( !res.equals(null)){
                    TextPassword.setText(res);*/
                   // TextEmail.setText(d);
                    editor.putString("UserEmail","Pedro");
                    editor.commit();
                    Intent intent=new Intent(MainActivity.this,dasboard.class);
                    //startActivity(intent);
               /* }else{
                    TextFails.setText("Email ou Senha Incorrecta");
                    return;
                }*/

            }
        });

    }

    //Método para inicializar componentes
    private void Iniciar(){
        this.logup=findViewById(R.id.logup);
        this.logar=findViewById(R.id.logar);
        this.TextEmail=(EditText)findViewById(R.id.TextEmail);
        this.TextPassword=(EditText)findViewById(R.id.TextPassword);
        this.TextFails=findViewById(R.id.textFails);
    }
}