package com.example.shoprise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Registro extends AppCompatActivity {

    private Spinner spinnerR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        spinnerR = (Spinner) findViewById(R.id.spinner);

        String [] paises =  {"España","Alemania","Portugal","Francia","Países Bajos","Grecia","Austria","Bélgica","Hungría","Irlanda","Bulgaria","Italia","Chequia","Chipre","Letonia","Lituania","Croacia","Luxemburgo","Dinamarca","Malta","Eslovaquia","Polonia","Eslovenia","Estonia","Rumania","Finlandia","Suecia"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises);
        spinnerR.setAdapter(adapter);
    };

    public void pincipalregistro(View view) {
        Intent principalregistro = new Intent(this, Principal.class);
        startActivity(principalregistro);

    }
}