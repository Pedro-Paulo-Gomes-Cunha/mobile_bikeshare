package com.example.kambabike10;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.kambabike10.Conexao.RetrofitConfig;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.Model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private Handler handler = new Handler();

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
        if(pref.contains("email")){
           this.TextEmail.setText(pref.getString("email", ""));
        }

        if(pref.contains("senha")){
            this.TextPassword.setText(pref.getString("senha", ""));
        }


        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);
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
                String text1= TextEmail.getText().toString();

               if(text1.isEmpty()){
                    TextFails.setText("Digite Seu Email");
                    return;
                }
                String text2= TextPassword.getText().toString();
                if(text2.isEmpty()){
                    TextFails.setText("Digite a Senha");
                    return;
                }

                // Começando a execução da thread responsável pela progressbar
                progressBar.setVisibility(View.VISIBLE);
                new Thread(new Runnable() {
                    public void run() {
                        while (progressStatus < 100) {
                            progressStatus += 1;
                            //Atualizand o progressbar e apresentando
                            handler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                }
                            });
                            try {
                                // Sleep for 200 milliseconds.
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
                Login();
           }
        });




    }

    //Método para inicializar componentes
    private void Iniciar(){
        this.logup=findViewById(R.id.logup);
        this.logar=findViewById(R.id.logar);
        this.TextEmail=(EditText)findViewById(R.id.textEmail);
        this.TextPassword=(EditText)findViewById(R.id.txtPassword);
        this.TextFails=findViewById(R.id.textFails);
    }

    private void Login(){
        Call<Usuario> call = new RetrofitConfig().GetUserService().GetLogin(TextEmail.getText().toString(),TextPassword.getText().toString());
        try {
            call.enqueue(new Callback<Usuario>() {
                @Override
                public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                    Usuario user = response.body();
                    assert user != null;

                    if(user==null){
                        TextFails.setText("Senha ou Email Inválido");
                        progressBar.setVisibility(View.INVISIBLE);
                    }else{
                        //TextEmail.setText(user.getNome());

                        SharedPreferences pref= getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
                        SharedPreferences.Editor editor = pref.edit();

                        editor.putString("id",user.getId().toString());
                        editor.putString("email",user.getLogin());
                        editor.putString("senha",user.getSenha());
                        editor.putString("perfil",user.getPerfil());
                        editor.putString("nome",user.getNome());
                        editor.putString("saldo",user.getSaldo().toString());
                        editor.commit();
                        Principal.setUserDados(user);
                        Intent intent=new Intent(MainActivity.this,dasboard.class);
                       // Principal.setIntent(intent);
                        startActivity(intent);
                    }

                }
                @Override
                public void onFailure(Call<Usuario> call, Throwable t) {
                    Log.e("UsuarioService   ", "Erro ao buscar o Usuario:" + t.getMessage());
                    TextFails.setText("Senha ou Email Inválido");
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });

        }catch (Exception e){
            TextFails.setText(e.getMessage());
            progressBar.setVisibility(View.INVISIBLE);
        }
    }
}