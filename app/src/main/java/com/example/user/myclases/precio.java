package com.example.user.myclases;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myclases.data.DataBaseManager;
import com.example.user.myclases.data.MyProfe;


public class precio extends Activity implements View.OnClickListener{
    private Button boton;
    private TextView nombre;
    private MyProfe globalVariable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precio);
        boton = (Button) findViewById(R.id.buttonmenu);
        boton.setOnClickListener(this);
        nombre= (TextView) findViewById(R.id.precio);

        globalVariable=(MyProfe)getApplicationContext();
    }

    public void onClick(View view) {

        if (view.getId()== R.id.buttonmenu) {
            DataBaseManager manager = new DataBaseManager(this);

                manager.modificarprecio(globalVariable.getContrasena(),nombre.getText().toString());
                Intent i=new Intent(this,Menus.class) ;
                startActivity(i);
                Toast toast = Toast.makeText(this, "Contraseña correcta", Toast.LENGTH_LONG);
                toast.show();


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
