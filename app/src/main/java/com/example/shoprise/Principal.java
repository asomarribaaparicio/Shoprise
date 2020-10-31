package com.example.shoprise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class Principal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        
        RecyclerView RecyclerViewM = findViewById(R.id.RecyclerView_Moda);
        RecyclerView RecyclerViewD = findViewById(R.id.ReciclerView_Deportes);
        RecyclerView RecyclerViewT = findViewById(R.id.RecyclerView_Tecno);
        RecyclerViewM.setHasFixedSize(true);
        RecyclerViewM.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewD.setHasFixedSize(true);
        RecyclerViewD.setLayoutManager(new LinearLayoutManager(this));
        RecyclerViewT.setHasFixedSize(true);
        RecyclerViewT.setLayoutManager(new LinearLayoutManager(this));


        Marca[] Moda = new Marca[]{
                new Marca(R.drawable.mango),
                new Marca(R.drawable.pull),
                new Marca(R.drawable.massimo),
                new Marca(R.drawable.zaraa),
                new Marca(R.drawable.bershka),
                new Marca(R.drawable.gucci),
                new Marca(R.drawable.vans),

        };

        Marca[] Deportes = new Marca[]{
                new Marca(R.drawable.adidas),
                new Marca(R.drawable.nike),
                new Marca(R.drawable.under),
                new Marca(R.drawable.rebook),
                new Marca(R.drawable.puma),
        };

        Marca[] Tecnología = new Marca[]{
                new Marca(R.drawable.apple),
                new Marca(R.drawable.lg),
                new Marca(R.drawable.xiaomi),
                new Marca(R.drawable.samsung),
                new Marca(R.drawable.pccomponentes),
                new Marca(R.drawable.mediamarkt),
        };

        MarcaAdapter MarcaAdapterM = new MarcaAdapter(Moda,Principal.this);
        RecyclerViewM.setAdapter(MarcaAdapterM);
        LinearLayoutManager layoutManagerM = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
        RecyclerViewM.setLayoutManager(layoutManagerM);

        MarcaAdapter MarcaAdapterD = new MarcaAdapter(Deportes,Principal.this);
        RecyclerViewD.setAdapter(MarcaAdapterD);
        LinearLayoutManager layoutManagerD = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
        RecyclerViewD.setLayoutManager(layoutManagerD);

        MarcaAdapter MarcaAdapterT = new MarcaAdapter(Tecnología,Principal.this);
        RecyclerViewT.setAdapter(MarcaAdapterT);
        LinearLayoutManager layoutManagerT = new LinearLayoutManager(this , LinearLayoutManager.HORIZONTAL , false);
        RecyclerViewT.setLayoutManager(layoutManagerT);


    }

    }
