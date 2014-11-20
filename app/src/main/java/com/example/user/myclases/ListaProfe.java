package com.example.user.myclases;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.example.user.myclases.data.DataBaseManager;


public class ListaProfe extends Activity {

    private DataBaseManager manager;
    private Cursor cursor;
    private ListView lista;
    private SimpleCursorAdapter adapter;
    private String a,p,c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_profe);
        Bundle bundle=getIntent().getExtras();
        a = bundle.getString("asignatura");
        p = bundle.getString("precio");
        c = bundle.getString("comuna");


        lista = (ListView) findViewById(R.id.listView1);

        manager = new DataBaseManager(this);

        String[] from = new String[]{manager.CN_NAME,manager.CN_APELLIDO};
        int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        cursor = manager.cargarCursorContactos(a,c,p);
        adapter = new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to,0);

        //TODO implementar ProfeCursorAdapter

        //ProfeCursorAdapter cursorAdapter = new ProfeCursorAdapter(getApplicationContext(),cursor,0);
        //lista.setAdapter(cursorAdapter);

        lista.setAdapter(adapter);


    
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

