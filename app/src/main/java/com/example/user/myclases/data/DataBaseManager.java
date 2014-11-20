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
    public static final String CN_PROFESOR = "profesor";
    public static final String CN_ALUMNO = "alumno";
    public static final String CN_MATEMATICAS = "matematicas";
    public static final String CN_FISICA = "fisica";
    public static final String CN_INGLES = "ingles";
    public static final String CN_PRECIO = "precio";
    public static final String CREATE_TABLE = "create table " +TABLE_NAME+ " ("
            + CN_ID + " integer primary key autoincrement,"
            + CN_NAME + " text not null,"
            + CN_APELLIDO + " text,"
            + CN_MAIL + " text,"
            + CN_CELULAR + " text,"
            + CN_COMUNA + " text,"
            + CN_PROFESOR + " text,"
            + CN_MATEMATICAS + " text,"
            + CN_INGLES + " text,"
            + CN_FISICA + " text,"
            + CN_PRECIO + " text,"
            + CN_ALUMNO + " text,"
            + CN_CLAVE + " text);";


    private MyProfeDbHelper helper;
    private SQLiteDatabase db;

    public DataBaseManager(Context context) {

        helper = new MyProfeDbHelper(context);
        db = helper.getWritableDatabase();
    }

    private ContentValues generarContentValues(String clave) {
        ContentValues valores = new ContentValues();
        valores.put(CN_CLAVE, clave);

        return valores;
    }



    public void insertar2(String nombre, String apellido, String mail, String celular, String comuna,String profesor,String alumno,String clave) {
        //INSERT INTO contactos   VALUES (null,'paco',9999)
        db.execSQL("insert into " + TABLE_NAME + " values (null,'" + nombre + "','" + apellido + "','" + mail + "','" + celular + "','" + comuna + "'," + profesor + ",0,0,0,0," + alumno + ",'" + clave + "')");
    }

    public void eliminar(String nombre) {
        //bd.delete (Tabla, Claúsula Where, Argumentos Where)
        db.delete(TABLE_NAME, CN_NAME + "=?", new String[]{nombre});
    }

    public void eliminarMultiple(String nom1, String nom2) {
        db.delete(TABLE_NAME, CN_NAME + "IN (?,?)", new String[]{nom1,nom2});
    }

    public void modificarprecio(String clave,String precio) {
        ContentValues valores = new ContentValues();
        valores.put(CN_PRECIO, precio);

        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, valores, CN_CLAVE + "= '"+clave+"'",null);
    }

    public void modificaringles(String clave) {
        ContentValues valores = new ContentValues();
        valores.put(CN_INGLES, "1");

        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, valores, CN_CLAVE + "='"+clave+"'",null);
    }
    public void modificarmatematicas(String clave) {
        ContentValues valores = new ContentValues();
        valores.put(CN_MATEMATICAS, "1");

        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, valores, CN_CLAVE + "='"+clave+"'",null);
    }

    public void modificarfisica(String clave) {
        ContentValues valores = new ContentValues();
        valores.put(CN_FISICA, "1");

        /*bd.update(TABLA, ContentValues, Clausula Where, Argumentos Where)*/
        db.update(TABLE_NAME, valores, CN_CLAVE + "='"+clave+"'",null);
    }


    public Cursor cargarCursorContactos(String asignatura, String comuna, String
            precio) {
        if(CN_MATEMATICAS.equals(asignatura)){
           if(precio.isEmpty()){
               if(comuna.isEmpty()){
                   return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE matematicas = 1 AND profesor = 1", null);
               }
           return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE matematicas = 1 AND profesor = 1 and comuna= '"+comuna+"'",null);
           }
           if(comuna.isEmpty()){
               return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE matematicas = 1 AND profesor = 1 and precio<= '"+precio+"'",null);
           }
            return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE matematicas = 1 AND profesor = 1 and comuna= '"+comuna+"' and precio <= '"+precio+"'",null);


    }
        if(CN_FISICA.equals(asignatura)){
            if(precio.isEmpty()){
                if(comuna.isEmpty()){
                    return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE fisica = 1 AND profesor = 1", null);
                }
                return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE fisica = 1 AND profesor = 1 and comuna= '"+comuna+"'",null);
            }
            if(comuna.isEmpty()){
                return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE fisica = 1 AND profesor = 1 and precio<= '"+precio+"'",null);
            }
            return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE fisica = 1 AND profesor = 1 and comuna= '"+comuna+"' and precio <= '"+precio+"'",null);


        }
        if(CN_INGLES.equals(asignatura)){
            if(precio.isEmpty()){
                if(comuna.isEmpty()){
                    return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE ingles = 1 AND profesor = 1", null);
                }
                return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE ingles = 1 AND profesor = 1 and comuna= '"+comuna+"'",null);
            }
            if(comuna.isEmpty()){
                return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE ingles = 1 AND profesor = 1 and precio<= '"+precio+"'",null);
            }
            return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE ingles = 1 AND profesor = 1 and comuna= '"+comuna+"' and precio <= '"+precio+"'",null);


        }
        if(asignatura.isEmpty()){
            if(precio.isEmpty()){
                if(comuna.isEmpty()){
                return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE profesor = 1", null);
                }
                return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE profesor = 1 AND comuna= '"+comuna+"'", null);
             }

            if (comuna.isEmpty()){
                return db.rawQuery("SELECT _id,nombre,apellido FROM usuarios WHERE profesor = 1 AND precio <= '"+precio+"'", null);
            }
        }


        return null;
        }

    public Cursor contraseña(String contraseña){
        String[] columnas = new String[]{CN_NAME};
        String[] whereargs = new String[]{contraseña};
        return db.query(TABLE_NAME, columnas, CN_CLAVE+"=?" ,whereargs, null, null, null);
    }
    public Cursor contraseña1(String contraseña) {
        Cursor mCursor =
                db.rawQuery("select nombre,apellido from usuarios WHERE clave= '" + contraseña + "';", null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor cargarCursorContactos2() {
        String[] columnas = new String[]{CN_ID, CN_NAME,CN_APELLIDO};
        return db.query(TABLE_NAME, columnas, CN_ALUMNO+"=1", null, null, null, null);
    }

    public Cursor InfoProfe(String nombre){
        Cursor elcursor =
                db.rawQuery("select nombre,apellido from usuarios WHERE nombre ='"+ nombre +"';",null);
        if (elcursor != null){
            elcursor.moveToFirst();

        }
        return elcursor;

    }

}
