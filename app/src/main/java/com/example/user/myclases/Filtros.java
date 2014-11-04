package com.example.user.myclases;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Filtros extends Activity implements View.OnClickListener{
    private TextView a,b,c;
    private Button d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);
        a=(TextView)findViewById(R.id.editTextPrecio);
        b=(TextView)findViewById(R.id.EditTextAsignatura);
        c=(TextView)findViewById(R.id.EditTextComuna1);
        d=(Button) findViewById(R.id.filtrarbt);
        d.setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {

        if (view.getId()== R.id.filtrarbt) {
            Intent i=new Intent(this,ListaProfe.class) ;
            i.putExtra("asignatura", b.getText().toString());
            i.putExtra("precio", a.getText().toString());
            i.putExtra("comuna", c.getText().toString());
            startActivity(i);




        }}


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
