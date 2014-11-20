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
 * Created by Albo on 20-11-2014.
 */
public class ProfePerfilAdapter extends CursorAdapter {
    private LayoutInflater layoutInflater;
    private DataBaseManager manager;

    public ProfePerfilAdapter(Context ctx, Cursor C, int flags ){
        super (ctx,C,flags);
        layoutInflater = (LayoutInflater) ctx.getSystemService(
                ctx.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.activity_perfilprofesor, viewGroup,false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView NombreView = (TextView) view.findViewById(R.id.textView);
        TextView ApellidoView = (TextView) view.findViewById(R.id.textView2);
        ImageView ViewImage = (ImageView) view.findViewById(R.id.imageView);

        String Nombre = cursor.getString(cursor.getColumnIndex(manager.CN_NAME));
        String Apellido = cursor.getString(cursor.getColumnIndex(manager.CN_APELLIDO));

        NombreView.setText(Nombre);
        ApellidoView.setText(Apellido);
        ViewImage.setImageResource(R.drawable.avatar);

    }
}