package com.example.user.myclases;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.myclases.data.DataBaseManager;

/**
 * Created by Diego on 19-11-2014.
 */
public class ProfeCursorAdapter extends CursorAdapter{
    private LayoutInflater layoutInflater;
    private DataBaseManager manager;

     public ProfeCursorAdapter(Context ctx, Cursor C, int flags ){
         super (ctx,C,flags);
         layoutInflater = (LayoutInflater) ctx.getSystemService(
                 ctx.LAYOUT_INFLATER_SERVICE);

     }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        //TODO colocar el layout de la fila correspondiente
        return layoutInflater.inflate(R.layout.listaprofescustomcursor, viewGroup,false);
        //return null;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        //TODO Obtener campos del layout de la fila

        TextView ViewNombre = (TextView) view.findViewById(R.id.textView3);
        ImageView ViewImage = (ImageView) view.findViewById(R.id.imageView2);


        //TODO Obtener datos del cursor (esta parado en una fila de los resultados)

        String Nombre = cursor.getString(cursor.getColumnIndex(manager.CN_NAME));
        String Apellido = cursor.getString(cursor.getColumnIndex(manager.CN_APELLIDO));

        //TODO  colocar datos del cursor en los campos del layout

        ViewNombre.setText("Nombre: "+Nombre);

        ViewImage.setImageResource(R.drawable.avatar);

    }
}
