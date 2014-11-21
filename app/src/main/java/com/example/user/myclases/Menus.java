package com.example.user.myclases;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Menus extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        Button Registrarse = (Button) findViewById(R.id.Buscarbutton);
        Registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menus.this,
                        Buscar.class);
                startActivity(intent);}});
        Button Registrar = (Button) findViewById(R.id.Precio);
        Registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menus.this,
                        MyPerfil.class);
                startActivity(intent);}});
        Button Registra = (Button) findViewById(R.id.Clasesbutton);
        Registra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menus.this,
                        Agendatuclase.class);
                startActivity(intent);}});
        Button Regist = (Button) findViewById(R.id.notificaciones1);
        Regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menus.this,
                        Notificaciones.class);
                startActivity(intent);}});
        Button Salir = (Button) findViewById(R.id.Salir);
        Salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menus.this,
                        LoginActivity.class);
                startActivity(intent);}});

    }




}