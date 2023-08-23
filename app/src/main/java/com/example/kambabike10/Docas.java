package com.example.kambabike10;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kambabike10.Conexao.Conexao;
import com.example.kambabike10.Helpers.DocaAdapter;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.Model.Doca;
import com.example.kambabike10.databinding.ActivityDocasBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Docas extends AppCompatActivity {
    Button teste;

    public final ArrayList<Doca> DocaList=new ArrayList<>();
    private ActivityDocasBinding binding;
    TextView t;
    String teste_1 ="https://api.funtranslations.com/translate/pirate.json?text=Hello%20sir%21%20my%20mother%20goes%20with%20me%20to%20the%20ocean";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docas);
        binding=ActivityDocasBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView ricycle =binding.ListaDocas;
        ricycle.setLayoutManager(new LinearLayoutManager(this));
        ricycle.setHasFixedSize(true);
        Doca dado=new Doca(1,"001",R.drawable.on,"Kilamba","10");
        Doca dado1=new Doca(2,"002",R.drawable.on,"Camama","10");
        Doca dado2=new Doca(3,"003",R.drawable.on,"Kilamba","10");
        Doca dado3=new Doca(4,"004",R.drawable.off,"Luanda","10");
        Doca dado4=new Doca(5,"005",R.drawable.on,"Kilamba","10");
        Doca dado5=new Doca(6,"006",R.drawable.on,"Kilamba","10");


        DocaList.add( dado);
        DocaList.add( dado1);
        DocaList.add( dado2);
        DocaList.add( dado3);
        DocaList.add( dado4);
        DocaList.add( dado5);

        DocaAdapter  adapter =new DocaAdapter(DocaList,this);
        ricycle.setAdapter(adapter);
        /*teste=findViewById(R.id.button3);
        t=findViewById(R.id.textView3);*/


       /*
                SharedPreferences pref= getApplicationContext().getSharedPreferences("MyPref",MODE_PRIVATE);
                t.setText(  pref.getString("Nome", ""));

                teste.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                /*Intent t=new Intent(Docas.this, dasboard.class);
                startActivity(t);*/
                     ///   String t1 = "oo";
               /* try {
                   ow new RuntimeException(e);
                }*/
        /*        t.setText(t1);
            }
        });*/
    }
}