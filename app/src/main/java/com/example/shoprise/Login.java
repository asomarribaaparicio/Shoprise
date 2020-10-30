package com.example.shoprise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void registro (View view)
    {
        Intent registrar = new Intent(this, Registro.class);
        startActivity(registrar);
    }
    public void pincipalogin(View view) {
        Intent principalogin = new Intent(this, Principal.class);
        startActivity(principalogin);
    }
}