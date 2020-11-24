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

import java.net.URI;
import java.net.URISyntaxException;

import static android.content.Intent.ACTION_VIEW;

public class Principal extends AppCompatActivity{

    private String marcaUrl;

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
                new Marca(R.drawable.mango, "mango", "https://shop.mango.com/es"),
                new Marca(R.drawable.pull, "pull","https://www.pullandbear.com/es/"),
                new Marca(R.drawable.massimo, "massimo","https://www.massimodutti.com/es/"),
                new Marca(R.drawable.zaraa, "zara","https://www.zara.com/es/"),
                new Marca(R.drawable.bershka, "bershka","https://www.bershka.com/"),
                new Marca(R.drawable.gucci, "gucci","https://www.gucci.com/es/es/"),
                new Marca(R.drawable.vans, "vans","https://www.vans.es/"),

        };

        Marca[] Deportes = new Marca[]{
                new Marca(R.drawable.adidas, "adidas","https://www.adidas.es/"),
                new Marca(R.drawable.nike, "nike","https://www.nike.com/es/"),
                new Marca(R.drawable.under, "under","https://www.underarmour.es/es-es/"),
                new Marca(R.drawable.rebook, "rebook","https://www.reebok.es/"),
                new Marca(R.drawable.puma, "puma","https://eu.puma.com/es/es/home"),
        };

        Marca[] Tecnología = new Marca[]{
                new Marca(R.drawable.apple, "apple","https://www.apple.com/es/"),
                new Marca(R.drawable.lg, "lg","https://www.lg.com/es"),
                new Marca(R.drawable.xiaomi, "xiaomi","https://mobile.mi.com/es/"),
                new Marca(R.drawable.samsung, "samsung","https://www.samsung.com/es/"),
                new Marca(R.drawable.pccomponentes, "pccomponentes","https://www.pccomponentes.com/"),
                new Marca(R.drawable.mediamarkt, "mediamarkt","https://www.mediamarkt.es/")
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


    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.listaD) {
                Intent listadeseos = new Intent(this, listadeseos.class);
                startActivity(listadeseos);
                finish();
            Toast.makeText(this, "Lista de deseos", Toast.LENGTH_SHORT).show();

        }
        return true;

    }

    public void internet(View view) throws URISyntaxException {
            marcaUrl = Marca.getMarcaUrl();
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(marcaUrl));
            startActivity(intent);
    }
}








