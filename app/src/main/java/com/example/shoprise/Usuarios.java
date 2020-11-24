package com.example.shoprise;

public class Usuarios {
    String usuarioid , nombre, apellidos, fechaNacimiento , pais , telefono , email , contraseña;

    public Usuarios(String usuarioid, String nombre, String apellidos, String fechaNacimiento, String pais, String email,
                    String telefono, String contraseña){
        this.usuarioid = usuarioid;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.email = email;
        this.telefono = telefono;
        this.contraseña = contraseña;
    }

    public String getUsuarioid() {
        return usuarioid;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public String getContraseña() {
        return contraseña;
    }
}
