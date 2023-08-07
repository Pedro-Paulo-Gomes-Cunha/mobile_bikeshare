package com.example.kambabike10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.kambabike10.Conexao.Conexao;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    private TextView logup,TextFails;
    private Button logar;
    EditText TextEmail, TextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        //Inializando a interação da tela cadastro com a tela de login
        Iniciar();
        //String t1=null;



       logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   Intent intent1= new Intent(MainActivity2.this,activity_cadastrar.class);
                startActivity(intent1);*/

                String t1="oo";
                try {
                    t1= Conexao.NewConexao2("");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                TextEmail.setText(t1);
            }
      });

        this.logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1= TextEmail.getText().toString();
               /* if(text1.isEmpty()){
                    TextFails.setText("Digite Seu Email");
                    return;
                }
                String text2= TextPassword.getText().toString();
                if(text2.isEmpty()){
                    TextFails.setText("Digite a Senha");
                    return;
                }*/
               // if(text1.equals("admin@bike.com") && text2.equals("admin")){
                    Intent intent=new Intent(MainActivity2.this,Chat.class);
                    startActivity(intent);
            /*    }else{
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