package com.example.shoprise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


    public class MarcaAdapter extends RecyclerView.Adapter<MarcaAdapter.ViewHolder> {

        Marca[] mimarcaData;
        Context context;

        public MarcaAdapter(Marca[] mimarcaData,Principal activity) {
            this.mimarcaData = mimarcaData;
            this.context = activity;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.list_element,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            final Marca myMarcaList = mimarcaData[position];
            holder.marcaImage.setImageResource(myMarcaList.getMarcaImage());
        }

        @Override
        public int getItemCount() {
            return mimarcaData.length;
        }


        public class ViewHolder extends RecyclerView.ViewHolder{
            ImageView marcaImage;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                marcaImage = itemView.findViewById(R.id.imagenMarca);


            }
        }
    }

