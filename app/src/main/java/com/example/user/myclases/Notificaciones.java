package com.example.user.myclases;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Notificaciones extends Activity {
    NotificationManager nm;
    private static final int ID_NOTIFICACION_PERSONAL = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificaciones);
        Button btn_lanzar = (Button) findViewById(R.id.btn_notificacion);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        btn_lanzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Notification notification = new Notification(R.drawable.ic_launcher, "Alumno 1", System.currentTimeMillis());

                PendingIntent intencionpendiente = PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), Contenido.class), 0);

                notification.setLatestEventInfo(getApplicationContext(), "Notificacion", "Alumno 1", intencionpendiente);

                nm.notify(ID_NOTIFICACION_PERSONAL, notification);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.notificaciones, menu);
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
