package com.example.gymfitness;

import android.provider.BaseColumns;

public class configurationDB {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Gymnasio.db";

    public static class usuario {
        public static final String TABLE_NAME = "tblUsuarios";
        public static final String COLUMN_NAME_NUSUARIO = "Usuario";
        public static final String COLUMN_NAME_NOMBRE = "Nombre";
        public static final String COLUMN_NAME_APE_PAT = "apellidoPat";
        public static final String COLUMN_NAME_APE_MAT = "apellidoMat";
        public static final String COLUMN_NAME_FECHANAC= "fechaNac";
        public static final String COLUMN_NAME_FECHAING= "fechaIng";
        public static final String COLUMN_NAME_CLAVE= "clave";
<<<<<<< HEAD
        public static final String COLUMN_NAME_GENERO = "IDgenero";
=======
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a

        public static String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        COLUMN_NAME_NUSUARIO + " TEXT PRIMARY KEY, " +
                        COLUMN_NAME_NOMBRE + " TEXT, " +
                        COLUMN_NAME_APE_PAT + " TEXT, " +
                        COLUMN_NAME_APE_MAT + " TEXT, "+
                        COLUMN_NAME_FECHANAC + " TEXT, "+
<<<<<<< HEAD
                        COLUMN_NAME_GENERO+ " INTEGER, "+
                        COLUMN_NAME_FECHAING + " TEXT, "+
                        COLUMN_NAME_CLAVE + " TEXT  ,"+
                        "foreign key ("+COLUMN_NAME_GENERO+") references "+genero.TABLE_NAME+"("+genero._ID+") )";
=======
                        COLUMN_NAME_FECHAING + " TEXT, "+
                        COLUMN_NAME_CLAVE + " TEXT ) ";

>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }

    public static class genero implements BaseColumns{
        public static final String TABLE_NAME = "tblGenero";
<<<<<<< HEAD
=======

>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        public static final String COLUMN_NAME_GENERO = "Genero";
        public static final String VALUE_NAME_FEMENINO = "Femenino";
        public static final String VALUE_NAME_MASCULINO = "Masculino";

        public static String SQL_CREATE_ENTRIES =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        _ID+ " INTEGER PRIMARY KEY, "+
                        COLUMN_NAME_GENERO+" TEXT)";

        public static final String SQL_DELETE_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME;
    }
}
