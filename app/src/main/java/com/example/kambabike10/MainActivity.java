package com.example.kambabike10;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kambabike10.Controller.UsuarioController;
import com.example.kambabike10.Helpers.Principal;

import java.util.concurrent.ExecutionException;


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
            this.TextEmail.setText(pref.getString("UserEmail", ""));
        }


        UsuarioController dado =new UsuarioController();

        try {
           TextFails.setText(dado.Logar());
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
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



                Principal.get_Principal().setTeste("dgdg");

                SharedPreferences pref= getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor editor = pref.edit();
                //UserEmail, UserId, UserName
                editor.putString("UserEmail","Angola");
                editor.commit();

                /*
                String text1= TextEmail.getText().toString();
                if(text1.isEmpty()){
                    TextFails.setText("Digite Seu Email");
                    return;
                }
                String text2= TextPassword.getText().toString();
                if(text2.isEmpty()){
                    TextFails.setText("Digite a Senha");
                    return;
                }*/
             //   if(text1.equals("admin@bike.com") && text2.equals("admin")){
                    Intent intent=new Intent(MainActivity.this,dasboard.class);
                    startActivity(intent);
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