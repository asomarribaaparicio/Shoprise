package com.example.shoprise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private Spinner spinnerR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        spinnerR = (Spinner) findViewById(R.id.spinner);

        String[] paises = {"España", "Alemania", "Portugal", "Francia", "Países Bajos", "Grecia", "Austria", "Bélgica", "Hungría", "Irlanda", "Bulgaria", "Italia", "Chequia", "Chipre", "Letonia", "Lituania", "Croacia", "Luxemburgo", "Dinamarca", "Malta", "Eslovaquia", "Polonia", "Eslovenia", "Estonia", "Rumania", "Finlandia", "Suecia"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises);
        spinnerR.setAdapter(adapter);
    }


    public void pincipalregistro(View view) {
        Intent principalregistro = new Intent(this, Principal.class);
        startActivity(principalregistro);

    }
} 
