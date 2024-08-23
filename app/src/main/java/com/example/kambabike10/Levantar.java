package com.example.kambabike10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kambabike10.Conexao.RetrofitConfig;
import com.example.kambabike10.Dto.DocaDto2;
import com.example.kambabike10.Helpers.Adaptador;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.Model.Share;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Levantar extends AppCompatActivity {

    ListView listarDocas, list2;
    androidx.appcompat.widget.Toolbar bar;

    private ProgressBar progressBar;
    private Handler handler = new Handler();
    private int progressStatus = 0;
    Button btn;
    TextView texto;
    String Parameto=null;
    public List<DocaDto2> DocaList1 = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavantar);

        bar = findViewById(R.id.toolbar);
        btn=findViewById(R.id.btnAction);
        progressBar = (ProgressBar) findViewById(R.id.progressBar_cyclic);
        texto=findViewById(R.id.Falha);
        texto.setTextSize(9);

        Intent intent=getIntent();
        Parameto=intent.getStringExtra("Nome");
        btn.setText( Parameto);

        Validar();//Validar se é possível realizar a operação

        listarDocas = (ListView) findViewById(R.id.ListaDocas);
        DocaList1.add (Principal.getDoca());

        Adaptador dados12 = new Adaptador( DocaList1, getApplicationContext());

        listarDocas.setAdapter(dados12);
        setSupportActionBar(bar);


    if(getSupportActionBar()!=null){
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

    bar.setNavigationOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent t=new Intent(getApplicationContext(),dasboard.class);
            startActivity(t);
        }
    });

    //btn Levantar ou Devolver
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(btn.getText().equals("Levantar")){
                //levantar

                // Começando a execução da thread responsável pela progressbar

                //  Processando();

                boolean result=Principal.LevantarBike(Principal.getDoca());

                if(result==true){

                    btn.setEnabled(true);
                    Toast.makeText(getApplicationContext(),  "Concluido com Sucesso", Toast.LENGTH_LONG).show();
                }else{

                    texto.setText(Principal.getTeste());

                }


                progressBar.setVisibility(View.VISIBLE);
                btn.setEnabled(false);
                new Thread(new Runnable() {
                    public void run() {
                        while (progressStatus < 50) {
                            progressStatus += 1;
                            //Atualizand o progressbar e apresentando
                            handler.post(new Runnable() {
                                public void run() {
                                    progressBar.setProgress(progressStatus);
                                    if(progressStatus==49){
                                        progressBar.setVisibility(View.INVISIBLE);
                                    }
                                }
                            });


                            try {
                                Thread.sleep(120);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }

                        }

                    }
                }).start();




            }else{
                //devolver
                Principal.DevolverBike(Principal.getDoca());
                texto.setText(Principal.getTeste());
                Toast.makeText(getApplicationContext(),  "Devolver!", Toast.LENGTH_LONG).show();
                Processando();
            }
        }
    });

        Principal.setContext(getApplicationContext());

    }


    private void Processando(){
        // Começando a execução da thread responsável pela progressbar
        progressBar.setVisibility(View.VISIBLE);
        btn.setEnabled(false);
          new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 50) {
                    progressStatus += 1;
                    //Atualizand o progressbar e apresentando
                    handler.post(new Runnable() {
                        public void run() {
                            progressBar.setProgress(progressStatus);
                            if(progressStatus==49){
                                progressBar.setVisibility(View.INVISIBLE);
                            }
                        }
                    });


                    try {
                        Thread.sleep(120);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }
        }).start();


    }


    private void Validar(){

        Call<Share> call1 = new RetrofitConfig().GetShareService().GetLastShare(String.valueOf(Principal.getUserDados().Id));
        call1.enqueue(new Callback<Share>() {
            @Override
            public void onResponse(Call<Share> call, Response<Share> response) {

                Share share_ =(Share) response.body();
                assert share_ != null;

                if(Parameto.equals("Levantar")){
                    btn.setEnabled(false);
                }


            }

            @Override
            public void onFailure(Call<Share> call, Throwable t) {
              //  texto.setText("Erro no processamento: "+t.getMessage());
                if(!Parameto.equals("Levantar")){
                    btn.setEnabled(false);
                }
            }
        });
    }



}