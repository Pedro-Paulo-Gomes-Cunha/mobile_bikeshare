package com.example.kambabike10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kambabike10.Conexao.Conexao;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class Docas extends AppCompatActivity {
    Button teste;
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docas);
        teste=findViewById(R.id.button3);
        t=findViewById(R.id.textView3);


        String t1 = "oo";
        try {
            t1 = new Conexao().execute().get();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t.setText(t1);
        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent t=new Intent(Docas.this, dasboard.class);
                startActivity(t);*/
                String t1 = "oo";
                try {
                    t1 = new Conexao().execute().get();
                } catch (ExecutionException e) {
                    throw new RuntimeException(e);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                t.setText(t1);
            }
        });
    }
}