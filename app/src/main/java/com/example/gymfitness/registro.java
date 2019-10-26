package com.example.gymfitness;




import android.app.AlertDialog;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class registro extends AppCompatActivity {
    private String SQL_SEARCH_ENTRIES =
            "SELECT * FROM "+configurationDB.genero.TABLE_NAME+" WHERE "+configurationDB.genero.COLUMN_NAME_GENERO+" = ?";
    private String genero;
    private int genero1 = 0;
    private int genero2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        llamadaFragment();
        configuracionesGlobales();
        //Revisar si existen los generos, de lo contrario ingresarlos
        genero1 = busquedaSQL(SQL_SEARCH_ENTRIES,configurationDB.genero.VALUE_NAME_MASCULINO);
        genero2 =busquedaSQL(SQL_SEARCH_ENTRIES,configurationDB.genero.VALUE_NAME_FEMENINO);

        if(genero1==0 && genero2 == 0){
            insertarGeneroSQL(configurationDB.genero.COLUMN_NAME_GENERO,configurationDB.genero.VALUE_NAME_FEMENINO);
            insertarGeneroSQL(configurationDB.genero.COLUMN_NAME_GENERO,configurationDB.genero.VALUE_NAME_MASCULINO);
        }
    }



    public void iniciarSesion(View view){
       mensajes mensaje = new mensajes();
       mensaje.Mcancelar(this,"¿Estas seguro de volver al inicio?\n" +
               "Se perderán todos los datos ingresados.","¿Ya tienes una cuenta?");

    }

    public void llamadaFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.idFragmentModifica, new register1());
        ft.commit();

    }
    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }
    public int busquedaSQL(String query,String Genero){
        int cantidad = 0;
        dbHelper db = new dbHelper(getApplicationContext(), configurationDB.DATABASE_NAME, null, configurationDB.DATABASE_VERSION);
        SQLiteDatabase sql = db.getReadableDatabase();
        String[] args = {Genero};
        if (sql != null) {
            Cursor c = sql.rawQuery(query,args);
            cantidad = c.getCount();
            db.close();
        }
        return cantidad;

    }

    public void insertarGeneroSQL(String clave,String valor){
        dbHelper dbHelper = new dbHelper(this,configurationDB.DATABASE_NAME,null,configurationDB.DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db!=null){
            ContentValues contentValues = new ContentValues();
            contentValues.put(clave,valor);
            long  x = db.insert(configurationDB.genero.TABLE_NAME,null,contentValues);
            Toast.makeText(this,""+x,Toast.LENGTH_SHORT).show();
            db.close();
        }
    }



}



