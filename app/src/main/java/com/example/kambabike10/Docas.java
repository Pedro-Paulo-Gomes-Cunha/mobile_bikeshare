package com.example.kambabike10;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kambabike10.Conexao.Conexao;
import com.example.kambabike10.Conexao.RetrofitConfig;
import com.example.kambabike10.Dto.DocaDto2;
import com.example.kambabike10.Helpers.Adaptador;
import com.example.kambabike10.Helpers.DocaAdapter;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.Model.Doca;
import com.example.kambabike10.Model.Usuario;
import com.example.kambabike10.databinding.ActivityDocasBinding;

import java.io.IOException;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Docas extends AppCompatActivity implements AdapterView.OnItemClickListener {
    Button teste;
    ListView listarDocas, list2;
    androidx.appcompat.widget.Toolbar bar;
    // Object-reference of our ListView
    ListView lvMonth;
    // String array to store the months that we'll generate programmatically
    String[] months;

    TextView teste2, texto;

    public List<DocaDto2> DocaList1 = null;
  //  private ActivityDocasBinding binding;
    TextView t;
    String teste_1 = "https://api.funtranslations.com/translate/pirate.json?text=Hello%20sir%21%20my%20mother%20goes%20with%20me%20to%20the%20ocean";

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docas);


        bar = findViewById(R.id.toolbar);
        listarDocas = (ListView) findViewById(R.id.ListaDocas);
        this.Docas();



        listarDocas.setOnItemClickListener(this);


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



    }

    @SuppressLint("NotConstructor")
    public void Docas() {
        DocaList1 = new ArrayList<>();

        Call<List<DocaDto2>> call = new RetrofitConfig().GetDocaService().DocaList();
        try {
            call.enqueue(new Callback<List<DocaDto2>>() {

                @Override
                public void onResponse(Call<List<DocaDto2>> call, Response<List<DocaDto2>> response) {
                    List<DocaDto2> res = response.body();

                    Adaptador dados12 = new Adaptador(res, getApplicationContext());

                    listarDocas.setAdapter(dados12);


                }

                @Override
                public void onFailure(Call<List<DocaDto2>> call, Throwable t) {
                    Log.e("DocaService ", "Erro ao buscar o Docas:" + t.getMessage());
                }
            });

        } catch (Exception e) {

        }

    }


    /**
     * @param parent   The AdapterView where the click happened.
     * @param view     The view within the AdapterView that was clicked (this
     *                 will be a view provided by the adapter)
     * @param position The position of the view in the adapter.
     * @param id       The row id of the item that was clicked.
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
     /*   DocaDto2 retorno=(DocaDto2) listarDocas.getAdapter().getItem( position);
        Principal.setDoca(retorno);

        Intent t=new Intent(this,Levantar.class);
        if(retorno.getStatus()==0){
            t.putExtra("Nome","Devolver");
        }else{
            t.putExtra("Nome","Levantar");
        }


        startActivity(t);*/

    }
}
