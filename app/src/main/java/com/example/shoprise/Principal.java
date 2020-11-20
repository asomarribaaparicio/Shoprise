package com.example.shoprise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static android.content.Intent.ACTION_VIEW;

public class Principal<marcaInternet> extends AppCompatActivity {


    private Bundle savedInstanceState;

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
                new Marca(R.drawable.mango, "mango"),
                new Marca(R.drawable.pull, "pull"),
                new Marca(R.drawable.massimo, "massimo"),
                new Marca(R.drawable.zaraa, "zara"),
                new Marca(R.drawable.bershka, "bershka"),
                new Marca(R.drawable.gucci, "gucci"),
                new Marca(R.drawable.vans, "vans"),

        };

        Marca[] Deportes = new Marca[]{
                new Marca(R.drawable.adidas, "adidas"),
                new Marca(R.drawable.nike, "nike"),
                new Marca(R.drawable.under, "under"),
                new Marca(R.drawable.rebook, "rebook"),
                new Marca(R.drawable.puma, "puma"),
        };

        Marca[] Tecnología = new Marca[]{
                new Marca(R.drawable.apple, "apple"),
                new Marca(R.drawable.lg, "lg"),
                new Marca(R.drawable.xiaomi, "xiaomi"),
                new Marca(R.drawable.samsung, "samsung"),
                new Marca(R.drawable.pccomponentes, "pccomponentes"),
                new Marca(R.drawable.mediamarkt, "mediamarkt"),
        };

        MarcaAdapter MarcaAdapterM = new MarcaAdapter(Moda, Principal.this);
        RecyclerViewM.setAdapter(MarcaAdapterM);
        LinearLayoutManager layoutManagerM = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewM.setLayoutManager(layoutManagerM);

        MarcaAdapter MarcaAdapterD = new MarcaAdapter(Deportes, Principal.this);
        RecyclerViewD.setAdapter(MarcaAdapterD);
        LinearLayoutManager layoutManagerD = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewD.setLayoutManager(layoutManagerD);

        MarcaAdapter MarcaAdapterT = new MarcaAdapter(Tecnología, Principal.this);
        RecyclerViewT.setAdapter(MarcaAdapterT);
        LinearLayoutManager layoutManagerT = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerViewT.setLayoutManager(layoutManagerT);


        public boolean onCreateOptionsMenu(Menu menu);{
            getMenuInflater().inflate(R.menu.overflow, menu);
            return true;
        }

        public boolean onOptionItemSelected(MenuItem item){
            int id= item.getItemId();




        }
    }









       /* public void linkInternet(View view, int position) {
        String posicionElemento = Marca.getMarcaNombre();
        Toast.makeText(this, posicionElemento, Toast.LENGTH_SHORT).show();


        if (posicionElemento.equals("mango")) {

            Uri uri = Uri.parse("https://shop.mango.com/es");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }*/



}
