package com.example.gymfitness;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText user;
    private TextInputEditText password;
    private boolean estadoRegistro = false;
    private String COLUMN_NAME_NUSUARIO;
    private String COLUMN_NAME_NOMBRE;
    private String COLUMN_NAME_APE_PAT;
    private String COLUMN_NAME_APE_MAT;
    private String COLUMN_NAME_FECHANAC;
    private String COLUMN_NAME_FECHAING;
    private String COLUMN_NAME_CLAVE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuracionesGlobales();
        //Revisamos si existe alguna peticion para agregar un registro a la db
        if(getIntent().getBooleanExtra("estado",estadoRegistro)){
            COLUMN_NAME_NUSUARIO = getIntent().getStringExtra("usuario");
            COLUMN_NAME_NOMBRE = getIntent().getStringExtra("nombre");
            COLUMN_NAME_APE_PAT = getIntent().getStringExtra("apellidoPat") ;
            COLUMN_NAME_APE_MAT = getIntent().getStringExtra("apellidoMat");
            COLUMN_NAME_FECHANAC = getIntent().getStringExtra("fechaNac");
            COLUMN_NAME_FECHAING = getIntent().getStringExtra("fechaIng");
            COLUMN_NAME_CLAVE = getIntent().getStringExtra("clave");

            insertar(COLUMN_NAME_NUSUARIO,COLUMN_NAME_NOMBRE,COLUMN_NAME_APE_PAT,COLUMN_NAME_APE_MAT,COLUMN_NAME_FECHANAC,COLUMN_NAME_FECHAING,COLUMN_NAME_CLAVE,this);

        }


    }


    public void verificaInput(View view){ //Metodo encargado de verificar si los input son rellenados correctamente
         user = (TextInputEditText)findViewById(R.id.inputUser);
         password = (TextInputEditText)findViewById(R.id.inputPassword);
        if(user.getText().toString().trim().equals("")){
            user.setError("Favor de rellenar con un usuario valido.");
        }
        else if(password.getText().toString().equals("")){
            password.setError("Favor de rellenar con una contraseña valida.");
        }
        else{
            //Condicional que sera usado para conectar con la DB y validar si los campos son correctos
            //
            Intent intent = new Intent(this,agEvaluacion.class);
            startActivity(intent);
        }
    }

    public void registrarCuenta(View view){
        Intent intent = new Intent(this,registro.class);
        startActivity(intent);
    }


    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }


    public void insertar(String usuario, String nombre, String apePat, String apeMat, String fechaNac, String fechaIng, String clave, Context context){
        dbHelper dbHelper = new dbHelper(getApplicationContext(),configurationDB.DATABASE_NAME,null,configurationDB.DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if(db!=null){
            ContentValues contentValues = new ContentValues();
            contentValues.put("Usuario","usuario");
            contentValues.put("Nombre","nombre");
            contentValues.put("apellidoPat","apePat");
            contentValues.put("apellidoMat","apeMat");
            contentValues.put("fechaNac","fechaNac");
            contentValues.put("fechaIng","fechaIng");
            contentValues.put("clave","clave");
            long nFilas = db.insert(configurationDB.usuario.TABLE_NAME,null,contentValues);
            Toast.makeText(this,""+nFilas,Toast.LENGTH_SHORT).show();
            db.close();
        }
    }

}
