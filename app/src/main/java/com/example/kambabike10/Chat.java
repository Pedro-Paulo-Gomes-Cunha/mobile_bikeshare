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
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Chat extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //side
    DrawerLayout draw;
    NavigationView Nav;
    androidx.appcompat.widget.Toolbar bar;

    //CircleImageView ImagemPerfil;
    TextView NomeUsuario;
    Intent intent;

    /*private EditText editText;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> taskList;
    private ImageButton btnSend;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        iniciar();
        side();
      //  setContentView(R.layout.activity_main);
        /*editText = (EditText)findViewById(R.id.newMessage);
        listView = (ListView) findViewById(R.id.MessageView);
        taskList = new ArrayList<>();
        btnSend=findViewById(R.id.btnsendMessage);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, taskList);
        listView.setAdapter(adapter);

        btnSend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                NewMessage();
            }
        });*/

    }

    private void NewMessage() {
       // String task = editText.getText().toString();

       /* if (!task.isEmpty()) {
            //    Log.d("MainActivity","adding  the tasktask");

            taskList.add(taskList.size()+1, task);
            adapter.notifyDataSetChanged();
            editText.setText("");
        }*/

    }

    //side
    @Override
    public void onBackPressed() {
        if(draw.isDrawerOpen(GravityCompat.START)){
            draw.closeDrawer(GravityCompat.START);
        }else{
            super.onBackPressed();
        }

    }

    private void iniciar(){
        draw=findViewById(R.id.drawlayout);
        Nav=findViewById(R.id.nav_view);
        bar = findViewById(R.id.toolbar);
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getTitleCondensed().toString()){
            case "Docas":
                Intent t=new Intent(Chat.this,Docas.class);
                startActivity(t);
                break;
           /* case "Sair":
                //Toast.makeText(this,"Share", Toast.LENGTH_SHORT).show();

                Intent t1=new Intent(Chat.this,Chat.class);
                startActivity(t1);
                break;*/

        }
        return true;
    }

}