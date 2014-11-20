package com.example.user.myclases;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import com.example.user.myclases.data.DataBaseManager;


public class Perfilprofesor extends Activity {

    private ListView lista;
    private Cursor cursor;
    String passedVar=null;
    private TextView passedView=null;
    private DataBaseManager manager;
    private String hola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfilprofesor);


        Bundle bundle=getIntent().getExtras();
        hola = bundle.getString("yeah");
        manager = new DataBaseManager(this);



        //cursor = manager.InfoProfe(hola);
        //lista = (ListView) findViewById(R.id.listView1);

        //ProfePerfilAdapter cursorAdapter = new ProfePerfilAdapter(getApplicationContext(),cursor,0);
        //lista.setAdapter(cursorAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.perfilprofesor, menu);
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
