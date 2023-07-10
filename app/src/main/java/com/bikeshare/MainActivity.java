package com.bikeshare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 private TextView logup;
 private Button logar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inializando a interação da tela cadastro com a tela de login
        Iniciar();
        logup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(MainActivity.this,activity_cadastrar.class);
                        startActivity(intent1);
            }
        });

        this.logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,activity_principal.class);
                startActivity(intent);
            }
        });

    }
    //Método para inicializar componentes
    private void Iniciar(){
        this.logup=findViewById(R.id.logup);
        this.logar=findViewById(R.id.logar);

    }
}