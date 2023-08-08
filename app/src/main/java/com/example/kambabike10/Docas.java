package com.example.kambabike10;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kambabike10.Conexao.Conexao;
import com.example.kambabike10.Helpers.Principal;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Docas extends AppCompatActivity {
    Button teste;
    TextView t;
    String teste_1 ="https://api.funtranslations.com/translate/pirate.json?text=Hello%20sir%21%20my%20mother%20goes%20with%20me%20to%20the%20ocean";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docas);
        teste=findViewById(R.id.button3);
        t=findViewById(R.id.textView3);


        String t1 = "oo";
       /* try {
            t1 = new Conexao(teste_1,"get").execute().get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setText(t1);*/
        SharedPreferences pref= getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
       t.setText(  pref.getString("Nome", ""));

        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent t=new Intent(Docas.this, dasboard.class);
                startActivity(t);*/
                String t1 = "oo";
               /* try {
                    t1 = new Conexao.NewConexao2("");
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }*/
                t.setText(t1);
            }
        });
    }
}