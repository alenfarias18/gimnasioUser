package com.example.gymfitness;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class dbHelper extends SQLiteOpenHelper {
    public dbHelper(Context context,String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //TABLA REGISTRO
        db.execSQL(configurationDB.usuario.SQL_CREATE_ENTRIES);

        //TABLA GENERO
        db.execSQL(configurationDB.genero.SQL_CREATE_ENTRIES);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //BORRAR REGISTRO
        //db.execSQL(configurationDB.usuario.SQL_DELETE_ENTRIES);
        //BORRAR GENERO
        //db.execSQL(configurationDB.genero.SQL_DELETE_ENTRIES);
    }
}
