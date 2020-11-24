package com.example.shoprise;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
    private EditText nombre;
    private EditText apellidos;
    private EditText fNacimiento;
    private EditText telefono;
    private Spinner pais;
    private EditText usuario;
    private EditText email;
    private EditText contraseña;
    private EditText repcontraseña;
    private Button bregistro;


    FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    //Variables de los datos que vamos a registrar
    private String dnombre = "";
    private String dapellidos = "";
    private String dfNacimiento = "";
    private String dtelefono = "";
    private String dusuario = "";
    private String dpais = "";
    private String demail = "";
    private String dcontraseña = "";
    private String drepContraseña;

    private Spinner spinnerR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        nombre =(EditText) findViewById(R.id.TextNombreUserR);
        apellidos =(EditText) findViewById(R.id.TextApellUserR);
        fNacimiento=(EditText) findViewById(R.id.TextFechaUserR);
        telefono =(EditText) findViewById(R.id.TextTelfUserR);
        email = (EditText) findViewById(R.id.TextEmailUserR);
        pais = (Spinner) findViewById(R.id.spinner) ;
        usuario = (EditText) findViewById(R.id.TextPersonUsuarioR);
        contraseña = (EditText) findViewById(R.id.TextPasswordR);
        repcontraseña =(EditText) findViewById(R.id.TextPasswordRepetirR);
        bregistro = (Button) findViewById(R.id.entrar);

        bregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dnombre = nombre.getText().toString();
                dapellidos = apellidos.getText().toString();
                dfNacimiento = fNacimiento.getText().toString();
                dtelefono = telefono.getText().toString();
                dpais = pais.getSelectedItem().toString();
                dusuario=usuario.getText().toString();
                dcontraseña =contraseña.getText().toString();
                demail=email.getText().toString();
                drepContraseña=repcontraseña.getText().toString();

                if(!dusuario.isEmpty() && !demail.isEmpty() && !dcontraseña.isEmpty() && !dnombre.isEmpty() && !dapellidos.isEmpty() && !dfNacimiento.isEmpty() && !dtelefono.isEmpty()
                         && !drepContraseña.isEmpty()) {
                    if (dcontraseña.length() >= 6) {
                        registrarUsuario();
                    }

                    else {
                        Toast.makeText(Registro.this, "La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(Registro.this, "Debe completar los campos obligatorios", Toast.LENGTH_SHORT).show();
                }


            }

        });
        //CREACIÓN DEL SPINNER
        spinnerR = (Spinner) findViewById(R.id.spinner);

        String[] paises = {"España", "Alemania", "Portugal", "Francia", "Países Bajos", "Grecia", "Austria", "Bélgica", "Hungría", "Irlanda", "Bulgaria", "Italia", "Chequia", "Chipre", "Letonia", "Lituania", "Croacia", "Luxemburgo", "Dinamarca", "Malta", "Eslovaquia", "Polonia", "Eslovenia", "Estonia", "Rumania", "Finlandia", "Suecia"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, paises);
        spinnerR.setAdapter(adapter);
    }

    private void registrarUsuario(){
        mAuth.createUserWithEmailAndPassword(demail, dcontraseña).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(Registro.this , Principal.class));
                    finish();
                    Map<String, Object>map = new HashMap<>();
                    map.put("nombre",dnombre);
                    map.put("apellidos",dapellidos);
                    map.put("fecha de nacimiento",dfNacimiento);
                    map.put("telefono",dtelefono);
                    map.put("pais",dpais);
                    map.put("usuario",dusuario);
                    map.put("contraseña",dcontraseña);
                    map.put("email",demail);
                    String id= mAuth.getCurrentUser().getUid();
                    mDatabase.child("Usuarios").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if (task2.isSuccessful()){
                                startActivity(new Intent(Registro.this , Principal.class));
                                finish();

                            }
                            else{
                                Toast.makeText(Registro.this, "No se han podido crear los datos correctamente", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Registro.this, "No se pudo registrar este usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}








