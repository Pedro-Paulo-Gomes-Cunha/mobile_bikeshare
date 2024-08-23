package com.example.kambabike10;




import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kambabike10.Conexao.RetrofitConfig;
import com.example.kambabike10.Dto.DocaDto2;
import com.example.kambabike10.Helpers.Adaptador;
import com.example.kambabike10.Helpers.Principal;
import com.example.kambabike10.databinding.ActivityDasboardBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class dasboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,AdapterView.OnItemClickListener{

    private Handler handler;

    public List<DocaDto2> DocaList=null;
    private ActivityDasboardBinding binding;
    DrawerLayout draw;
    NavigationView Nav;
    androidx.appcompat.widget.Toolbar bar;
    ListView listarDocas;
    TextView Nome, Saldo;
    ImageView ima;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        //inicializando componentes
        iniciar();
        //side start
        side();
        MostrarDocas();

        listarDocas.setOnItemClickListener(this);

        ima=findViewById(R.id.imageView2);

       /* ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MostrarDocas();

                Toast.makeText(getApplicationContext(),"Atualizou", Toast.LENGTH_LONG).show();
            }
        });*/





           this.Nome.setText(Principal.UserDados.getNome());

           this.Saldo.setText("Saldo: "+Principal.UserDados.getSaldo()+"pts");




    }

    private void side(){
        //toolbar


        Nav.bringToFront(); //Efeito de clique nos itens do menu

        ////Navegation Menu
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,draw,bar,R.string.navi_opem, R.string.navi_close);
        draw.addDrawerListener(toggle);
        toggle.syncState();

        Nav.setNavigationItemSelectedListener(this);

        Menu menu=Nav.getMenu();
        menu.findItem(R.id.nav_home7).setVisible(true);
    }
    private void iniciar(){
        draw=findViewById(R.id.drawlayout);
        Nav=findViewById(R.id.nav_view);
        bar = findViewById(R.id.toolbar);
        listarDocas=(ListView) findViewById(R.id.listdocas1);
        Nome= findViewById(R.id.textView);
        Saldo= findViewById(R.id.textView2);

    }

    @Override
    public void onBackPressed() {
        if(draw.isDrawerOpen(GravityCompat.START)){
            draw.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getTitleCondensed().toString()){
            case "Docas":
                Intent t=new Intent(dasboard.this,Docas.class);
                startActivity(t);
                break;
           case "Sair":
                Toast.makeText(this,"Share", Toast.LENGTH_SHORT).show();

               Intent t1=new Intent(dasboard.this,Chat.class);
               startActivity(t1);
                break;

        }
        return true;
    }




    private void MostrarDocas(){
        Call<List<DocaDto2>> call = new RetrofitConfig().GetDocaService().DocaList();
        try {
            call.enqueue(new Callback<List<DocaDto2>>() {

                @Override
                public void onResponse(Call<List<DocaDto2>> call, Response<List<DocaDto2>> response) {
                    List<DocaDto2> res =response.body();
                    assert res!=null;

                    Adaptador dados =new Adaptador(res,getApplicationContext());
                    listarDocas.setAdapter(dados);
                }
                @Override
                public void onFailure(Call<List<DocaDto2>> call, Throwable t) {
                    Log.e("DocaService ", "Erro ao buscar o Docas:" + t.getMessage());
                }
            });

        }catch (Exception e){
            Log.e("DocaService ", "Erro ao buscar o Docas:" + e.getMessage());
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
        DocaDto2 retorno=(DocaDto2) listarDocas.getAdapter().getItem( position);
        Principal.setDoca(retorno);

        Intent t=new Intent(this,Levantar.class);
        if(retorno.getStatus()==0){
            t.putExtra("Nome","Devolver");
        }else{
            t.putExtra("Nome","Levantar");
        }


        startActivity(t);

    }

}