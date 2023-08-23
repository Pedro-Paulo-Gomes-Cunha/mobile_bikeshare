package com.example.kambabike10;




import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.kambabike10.Helpers.DocaAdapter;
import com.example.kambabike10.Model.Doca;
import com.example.kambabike10.databinding.ActivityDasboardBinding;
import com.example.kambabike10.databinding.ActivityDocasBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class dasboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{



    public final ArrayList<Doca> DocaList=new ArrayList<>();
    private ActivityDasboardBinding binding;
    DrawerLayout draw;
    NavigationView Nav;
    androidx.appcompat.widget.Toolbar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dasboard);

        //inicializando componentes

        iniciar();

        //side start
        side();




        MostrarDocas();




    }

    private void side(){
        //toolbar
        setSupportActionBar(bar);

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

    private void CarregarDocas(){
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

    }

    private void MostrarDocas(){

        binding= ActivityDasboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        RecyclerView ricycle =binding.ListaDocas;
        ricycle.setLayoutManager(new LinearLayoutManager(this));
        ricycle.setHasFixedSize(true);
        CarregarDocas();

        DocaAdapter adapter =new DocaAdapter(DocaList,this);
        ricycle.setAdapter(adapter);
    }
}