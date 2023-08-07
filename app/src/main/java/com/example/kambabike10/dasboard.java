package com.example.kambabike10;




import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;
public class dasboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

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
}