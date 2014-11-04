package com.example.user.myclases;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.user.myclases.data.DataBaseManager;


public class precio extends Activity implements View.OnClickListener{
    private Button boton;
    private TextView nombre,contrase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precio);
        boton = (Button) findViewById(R.id.buttonmenu);
        boton.setOnClickListener(this);
        nombre= (TextView) findViewById(R.id.precio);
        contrase=(TextView)findViewById(R.id.password);
    }

    public void onClick(View view) {

        if (view.getId()== R.id.buttonmenu) {
            DataBaseManager manager = new DataBaseManager(this);
            String con = contrase.getText().toString();
            if(manager.contraseña(con).moveToFirst()){
                manager.modificarprecio(contrase.getText().toString(),nombre.getText().toString());
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
        getMenuInflater().inflate(R.menu.precio, menu);
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
