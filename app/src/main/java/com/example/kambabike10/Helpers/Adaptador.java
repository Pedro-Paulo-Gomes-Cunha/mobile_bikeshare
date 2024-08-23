package com.example.kambabike10.Helpers;

import static androidx.core.content.ContextCompat.getMainExecutor;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kambabike10.Docas;
import com.example.kambabike10.DocasItem;
import com.example.kambabike10.Dto.DocaDto2;
import com.example.kambabike10.MainActivity;
import com.example.kambabike10.Model.Doca;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import com.example.kambabike10.R;
import com.example.kambabike10.dasboard;

import java.util.ArrayList;
import java.util.List;

public class Adaptador extends BaseAdapter {


    public final List<DocaDto2> DocaList;
    public final Context context;
    LayoutInflater inflate;

    public Adaptador(List<DocaDto2> docaList, Context context) {
        DocaList = docaList;
        this.context = context;
        inflate=LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return  DocaList.size();
    }

    @Override
    public Object getItem(int position) {

        return DocaList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView=inflate.inflate(R.layout.docasitem,null);


        TextView DocId=(TextView)convertView.findViewById(R.id.DocId);
        TextView EstacaoId=(TextView)convertView.findViewById(R.id.estacaoId);
        TextView bonus=(TextView)convertView.findViewById(R.id.bonus);

        ImageView status=(ImageView)convertView.findViewById(R.id.Imgstatus);

       // Button btn =(Button)convertView.findViewById(R.id.levantar);


        DocId.setText("Doca: "+DocaList.get(position).getNome());
       bonus.setText("Prêmio: "+DocaList.get(position).getPremio().toString()+"pts");
        EstacaoId.setText("Estação: "+DocaList.get(position).getEstacao());

        //colocando as imagens de estado e desativando btn se estiver off
        if (DocaList.get(position).getStatus()==1) {
            status.setImageResource(R.drawable.on);
        } else {
            status.setImageResource(R.drawable.off);
           // btn.setEnabled(false);
        }


      /* btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Aplicar aqui a chamada da regra de negócio
                //Principal.setDoca(DocaList.get(position));
              boolean result=false;//  Principal.LevantarBike(DocaList.get(position));

              if(result==false){
                 // Toast.makeText(context,  "Falha no Levantamento!", Toast.LENGTH_LONG).show();


              }else{



              }

                //Here perform the action you want

               // Principal.setControl(true);



            }

        });*/


        return convertView;
    }
}
