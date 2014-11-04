package com.example.user.myclases;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myclases.data.DataBaseManager;

import static com.example.user.myclases.R.id.volver;


public class asignatura extends Activity implements View.OnClickListener {

    private TextView contrase ;
    private CheckBox fisica,matematicas,ingles;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignatura);
        boton = (Button) findViewById(R.id.volver);
        boton.setOnClickListener(this);
        contrase = (TextView) findViewById(R.id.contraseña);
        fisica=(CheckBox) findViewById(R.id.fisica);
        matematicas=(CheckBox) findViewById(R.id.matematicas);
        ingles=(CheckBox) findViewById(R.id.ingles);

    }
    @Override
    public void onClick(View view) {

        if (view.getId()== volver) {
            DataBaseManager manager = new DataBaseManager(this);
            String con = contrase.getText().toString();
            if(manager.contraseña(con).moveToFirst()){
            if(fisica.isChecked()){
                manager.modificarfisica(con);
            }
            if(matematicas.isChecked()){
                manager.modificarmatematicas(con);
            }
            if(ingles.isChecked()){
                manager.modificaringles(con);
            }
            Intent i=new Intent(this,Menus.class) ;
            startActivity(i);
                Toast toast = Toast.makeText(this, "Contraseña correcta", Toast.LENGTH_LONG);
                toast.show();}

        else{
            Toast toast = Toast.makeText(this, "Contraseña incorrecta", Toast.LENGTH_LONG);
            toast.show();}
            }}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.asignatura, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
