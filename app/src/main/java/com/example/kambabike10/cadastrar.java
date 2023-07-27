package com.example.kambabike10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class cadastrar extends AppCompatActivity {
    private Button Cancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar);
        iniciarComponentes();

        this.Cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(cadastrar.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void iniciarComponentes(){
        this.Cancelar=findViewById(R.id.Cancelar);
    }
}