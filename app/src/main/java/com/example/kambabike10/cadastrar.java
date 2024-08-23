package com.example.kambabike10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.kambabike10.Conexao.RetrofitConfig;
import com.example.kambabike10.Dto.Login;
import com.example.kambabike10.Dto.UsuarioDto;
import com.example.kambabike10.Model.Usuario;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class cadastrar extends AppCompatActivity {
    private Button Cancelar, Adicionar;

    EditText TextEmail, TextPassword,TextPassword2,TextNome;
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


        this.Adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //validaçoes

                if(TextNome.getText().toString().isEmpty()){
                    Toast.makeText(cadastrar.this, "Digite Seu Nome", Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextEmail.getText().toString().isEmpty()){
                    Toast.makeText(cadastrar.this, "Digite Seu Email", Toast.LENGTH_LONG).show();
                    return;
                }

                if(TextPassword.getText().toString().isEmpty()){
                    Toast.makeText(cadastrar.this,"Digite a Senha", Toast.LENGTH_LONG).show();
                    return;
                }
                if(TextPassword2.getText().toString().isEmpty()){
                    Toast.makeText(cadastrar.this, "Digite a confirmaçao da Senha", Toast.LENGTH_LONG).show();
                    return;
                }

                if(!TextPassword2.getText().toString().equals(TextPassword.getText().toString())){
                    Toast.makeText(cadastrar.this, "Confirmaçao da Senha Incorrecta", Toast.LENGTH_LONG).show();
                    return;
                }

                //Método para salvar os dados
                novoUsuario();
              /*  Intent intent=new Intent(cadastrar.this,MainActivity.class);
                startActivity(intent);*/
            }
        });

    }

    private void iniciarComponentes(){
        this.Cancelar=findViewById(R.id.Cancelar);
        this.Adicionar=findViewById(R.id.logar);
        this.TextEmail=findViewById(R.id.textEmail);
        this.TextPassword=findViewById(R.id.txtPassword);
        this.TextPassword2=findViewById(R.id.txtPassword2);
        this.TextNome=findViewById(R.id.txtNome);

    }

    private void novoUsuario(){
        UsuarioDto savedado = new UsuarioDto(this.TextNome.getText().toString(), this.TextEmail.getText().toString(), this.TextPassword.getText().toString(), "cliente",10.0);
       try {
           Call<Object> call = new RetrofitConfig().GetUserService().SaveUser(savedado);
           call.enqueue(new Callback<Object>() {
               @Override
               public void onResponse(Call<Object> call, Response<Object> response) {
                   try {
                       int codigo= response.code();
                       if (codigo==201) {
                           Toast.makeText(getApplicationContext(), "Cadastrado com Sucesso", Toast.LENGTH_SHORT).show();
                           Intent intent=new Intent(cadastrar.this,MainActivity.class);
                           startActivity(intent);
                       } else {
                           Toast.makeText(getApplicationContext(), "Falha no Cadastro " + codigo, Toast.LENGTH_SHORT).show();
                       }

                   } catch (Exception e) {
                       Log.d("Exception", e.toString());
                   }

               }

               @Override
               public void onFailure(Call<Object> call, Throwable t) {

               }


           });

    }catch (Exception e){
           Toast.makeText(cadastrar.this, e.toString(), Toast.LENGTH_LONG).show();
    }

    }
}
