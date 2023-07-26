package com.example.kambabike10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Docas extends AppCompatActivity {
    Button teste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docas);
        teste=findViewById(R.id.button3);

        teste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent t=new Intent(Docas.this, dasboard.class);
                startActivity(t);
            }
        });
    }
}