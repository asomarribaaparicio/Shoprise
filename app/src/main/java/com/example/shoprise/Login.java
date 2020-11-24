package com.example.shoprise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Login extends AppCompatActivity {

    private EditText email;
    private EditText contraseña;
    private Button blogin;

    private String demail ="";
    private String dcontraseña ="";

    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();

        email = (EditText) findViewById(R.id.emailLogin);
        contraseña = (EditText) findViewById(R.id.contraseñaLogin);
        blogin = (Button) findViewById(R.id.btnLogin);

        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demail = email.getText().toString();
                dcontraseña = contraseña.getText().toString();

                if (!demail.isEmpty() && !dcontraseña.isEmpty()) {
                    loginUsuario();
                } else {
                    Toast.makeText(Login.this, "Debe completar los campos obligatorios", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void loginUsuario() {
        mAuth.signInWithEmailAndPassword(demail,dcontraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(Login.this,Principal.class));
                    finish();
                    Toast.makeText(Login.this, "¡Bienvenido!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Login.this, "No se puede iniciar sesión, comprueba los datos", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void registro (View view)
    {
        Intent registrar = new Intent(this, Registro.class);
        startActivity(registrar);
    }

}