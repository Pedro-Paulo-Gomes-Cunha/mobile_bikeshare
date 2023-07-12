package com.bikeshare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class activity_principal extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
 DrawerLayout draw;
 NavigationView Nav;
    androidx.appcompat.widget.Toolbar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //inicializando componentes
        iniciar();

        //toolbar
        setSupportActionBar(bar);

        Nav.bringToFront(); //Efeito de clique nos itens do menu

        ////Navegation Menu
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,draw,bar,R.string.navi_opem, R.string.navi_close);
        draw.addDrawerListener(toggle);
        toggle.syncState();

        Nav.setNavigationItemSelectedListener(this);
    }

    private void iniciar(){
        draw=findViewById(R.id.drawlayout);
        Nav=findViewById(R.id.nav_view);
        bar = findViewById(R.id.bar);
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
        return true;
    }
}