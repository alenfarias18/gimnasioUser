package com.example.gymfitness;



public class configuracionDB {
    //Version de la base de datos
    public static final int DATABASE_VERSION = 1;
    //Nombre de la base de datos
    public static final String DATABASE_NAME = "gimnasioDB";
        //En caso de modificar algun nombre basta con modificar el valor de las variables.

        //registro
        public static class registro {
            public static final String TABLE_NAME = "tblRegistro";
            public static final String COLUMN_NAME_USUARIO = "TextUsuario";
            public static final String COLUMN_NAME_NOMBRE = "TextNombre";
            public static final String COLUMN_NAME_APELLIDOM = "TextApellidoM";
            public static final String COLUMN_NAME_APELLIDOP = "TextApellidoM";
            public static final String COLUMN_NAME_FECHA_NACIMIENTO = "IDIntFechaNac";
            public static final String COLUMN_NAME_GENERO = "TextGenero";
            public static final String COLUMN_NAME_FECHA_INGRESO = "IDIntFechaIng";
            public static final String COLUMN_NAME_PASSWORD = "TextPassword";
        }

        public static String SQL_CREATE_REGISTRO =
                "CREATE TABLE " + registro.TABLE_NAME + " ("
                        +registro.COLUMN_NAME_USUARIO+ " TEXT PRIMARY KEY,"
                        +registro.COLUMN_NAME_PASSWORD+"TEXT,"
                        +registro.COLUMN_NAME_NOMBRE + "TEXT,"
                        +registro.COLUMN_NAME_APELLIDOP + "TEXT,"
                        +registro.COLUMN_NAME_APELLIDOM + "TEXT,"
                        +registro.COLUMN_NAME_FECHA_NACIMIENTO+ "TEXT,"
                        +registro.COLUMN_NAME_GENERO + "TEXT,"
                        +registro.COLUMN_NAME_FECHA_INGRESO+"TEXT"
                        +")";

        public static final String SQL_DELETE_REGISTRO =
                "DROP TABLE IF EXISTS " + registro.TABLE_NAME;

}
