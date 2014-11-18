package com.example.user.myclases;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Filtros extends Activity implements View.OnClickListener{
    private TextView a;
    private Button d;
    private Spinner spinner1,b,spinner2,c;
    private List<String> lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);
        a=(TextView)findViewById(R.id.editTextPrecio);
        b=(Spinner)findViewById(R.id.spinner1);
        c=(Spinner)findViewById(R.id.spinner2);
        d=(Button) findViewById(R.id.filtrarbt);
        d.setOnClickListener(this);
        DatosPorDefecto();
        DatosPorDefecto1();

    }
    @Override
    public void onClick(View view) {

        if (view.getId()== R.id.filtrarbt) {
            Intent i=new Intent(this,ListaProfe.class) ;
            i.putExtra("asignatura", b.getSelectedItem().toString());
            i.putExtra("precio", a.getText().toString());
            i.putExtra("comuna", c.getSelectedItem().toString());
            startActivity(i);




        }}
    private void DatosPorDefecto() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        lista = new ArrayList<String>();
        spinner1 = (Spinner) this.findViewById(R.id.spinner1);
        lista.add("");
        lista.add("matematicas");
        lista.add("fisica");
        lista.add("ingles");

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adaptador);
    }
    private void DatosPorDefecto1() {
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        lista = new ArrayList<String>();
        spinner2= (Spinner) this.findViewById(R.id.spinner2);
        lista.add("");
        lista.add("La Reina");
        lista.add("Las Condes");
        lista.add("La Dehesa");
        lista.add("Peñalolen");
        lista.add("Providencia");
        lista.add("Vitacura");
        lista.add("Independencia");
        lista.add("Santiago");
        lista.add("Renca");
        lista.add("La Pintana");
        lista.add("Quinta Normal");
        lista.add("Maipu");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adaptador);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.filtros, menu);
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
