package com.example.user.myclases;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.user.myclases.data.DataBaseManager;

public class MyActivity extends Activity implements View.OnClickListener {
    private SQLiteDatabase db;
    private Button boton,boto;
    private Button btn;
    private TextView nombre;
    private TextView apellido;
    private TextView mail;
    private TextView celular;
    private TextView comuna;
    private TextView clave;
    private CheckBox profesor,alumno;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        boton = (Button) findViewById(R.id.ButtonEnviar);
            boton.setOnClickListener(this);
        btn = (Button) findViewById(R.id.ButtonResetear);
        nombre = (TextView) findViewById(R.id.EditTextNombre);
        apellido = (TextView) findViewById(R.id.EditTextApellido);
        mail = (TextView) findViewById(R.id.EditTextEmail);
        celular = (TextView) findViewById(R.id.editTextCelular);
        comuna = (TextView) findViewById(R.id.editTextComuna);
        clave = (TextView) findViewById(R.id.editTextClave);
        profesor=(CheckBox) findViewById(R.id.checkBox2);
        alumno=(CheckBox) findViewById(R.id.checkBox);
        boto = (Button) findViewById(R.id.ButtonEnviar);
        boto.setOnClickListener(this);




}
    private DataBaseManager manager;
    @Override
    public void onClick(View view) {

        if (view.getId()== R.id.ButtonEnviar) {
            String primero = nombre.getText().toString();
            String segundo =apellido.getText().toString();
            String tercero =mail.getText().toString();
            String cuarto =celular.getText().toString();
            String quinto =comuna.getText().toString();
            String sexto =clave.getText().toString();
            String uno ="1";
            String cero ="0";
            if(profesor.isChecked()==true){if(alumno.isChecked()==true){
            manager = new DataBaseManager(this);
            manager.insertar2(primero,segundo,tercero,cuarto,quinto,uno,uno,sexto);
                }
            else{
                manager = new DataBaseManager(this);
                manager.insertar2(primero,segundo,tercero,cuarto,quinto,uno,cero,sexto);}
            }
            else{ manager = new DataBaseManager(this);
                manager.insertar2(primero,segundo,tercero,cuarto,quinto,cero,uno,sexto);}
            Intent a = new Intent(this, Menus.class);
            startActivity(a);}
        if (view.getId() == R.id.ButtonResetear) {

            nombre.setText("");
            apellido.setText("");
            mail.setText("");
            celular.setText("");
            comuna.setText("");
            clave.setText("");
        }



}}
