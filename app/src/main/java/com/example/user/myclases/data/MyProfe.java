package com.example.user.myclases.data;

/**
 * Created by user on 17-11-14.
 */
import android.app.Application;
public class MyProfe extends Application{
    // Variables
    private String nombre = "", contraseña = "";

    // Getter Nombre
    public String getNombre(){
        return nombre;
    }

    // Setter Nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // Getter Apellido
    public String getContrasena(){
        return contraseña;
    }

    // Setter Apellido
    public void setContrasena(String contraseña){
        this.contraseña = contraseña;
    }
}