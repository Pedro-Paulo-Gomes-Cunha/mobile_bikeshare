package com.example.kambabike10.Helpers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kambabike10.Model.Doca;
import com.example.kambabike10.databinding.ActivityDocasBinding;
import com.example.kambabike10.databinding.DocasitemBinding;

import java.util.ArrayList;

public class DocaAdapter extends RecyclerView.Adapter<DocaAdapter.DocaView> {

    public final ArrayList<Doca> DocaList;
    public final Context context;

    public DocaAdapter(ArrayList<Doca> docaList, Context context) {
        DocaList = docaList;
        this.context = context;
    }

    public static class DocaView  extends RecyclerView.ViewHolder{
        DocasitemBinding binding;
        public DocaView( DocasitemBinding _binding) {
            super(_binding.getRoot());
            this.binding= _binding;
        }
    }
    @NonNull
    @Override
    public DocaView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DocasitemBinding list;



        list= DocasitemBinding.inflate(LayoutInflater.from(context),parent,false);

        return new DocaView(list);
    }

    @Override
    public void onBindViewHolder(@NonNull DocaView holder, int position) {
       // holder.binding.ImgDoca.setBackgroundResource(DocaList.get(position).getImagem());
        holder.binding.DocId.setText("Doca: "+DocaList.get(position).getNome());
        holder.binding.bonus.setText(DocaList.get(position).getBonus().toString()+"pt");
        holder.binding.estacaoId.setText("Estação: "+DocaList.get(position).getEstacao());
        holder.binding.statusImg.setBackgroundResource(DocaList.get(position).getStatus());

    }

    @Override
    public int getItemCount() {
        return DocaList.size();
    }
}
