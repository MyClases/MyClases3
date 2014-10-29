package com.example.user.myclases.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Albo on 29-10-2014.
 */
public class DataBaseManager {
    public static final String TABLE_NAME = "usuarios";

    public static final String CN_ID = "_id";
    public static final String CN_NAME = "nombre";
    public static final String CN_APELLIDO = "apellido";
    public static final String CN_MAIL = "mail";
    public static final String CN_CELULAR = "celular";
    public static final String CN_COMUNA = "comuna";
    public static final String CN_CLAVE = "clave";

    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_NAME + " text not null,"
            + CN_APELLIDO + " text,"
            + CN_MAIL + " text,"
            + CN_CELULAR + " text,"
            + CN_COMUNA + " text,"
            + CN_CLAVE + " text);";

    private MyProfeDbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {

        helper = new MyProfeDbHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String nombre, String telefono) {
        ContentValues valores = new ContentValues();
        valores.put(CN_NAME, nombre);
        valores.put(CN_APELLIDO, telefono);
        return valores;
    }

    public void insertar(String nombre, String telefono) {
        //bd.insert(TABLA, NullColumnHack, ContentValues);
        db.insert(TABLE_NAME, null, generarContentValues(nombre, telefono));
    }

    public void insertar2(String nombre, String apellido, String mail, String celular, String comuna, String clave) {
        //INSERT INTO contactos   VALUES (null,'paco',9999)
        db.execSQL("insert into " + TABLE_NAME + " values (null,'" + nombre + "','" + apellido + "','" + mail + "','" + celular + "','" + comuna + "','" + clave + "')");
    }

    public void eliminar(String nombre) {
        //bd.delete (Tabla, Claúsula Where, Argumentos Where)
        db.delete(TABLE_NAME, CN_NAME + "=?", new String[]{nombre});
    }

    public void eliminarMultiple(String nom1, String nom2) {
        db.delete(TABLE_NAME, CN_NAME + "IN (?,?)", new String[]{nom1,nom2});
    }

    public void modificarTelefono(String nombre, String nuevoTelefono) {
        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, generarContentValues(nombre, nuevoTelefono), CN_NAME + "=?", new String[]{nombre});
    }

    public Cursor cargarCursorContactos() {
        String[] columnas = new String[]{CN_ID, CN_NAME,CN_APELLIDO};
        return db.query(TABLE_NAME, columnas, null, null, null, null, null);
    }
}
