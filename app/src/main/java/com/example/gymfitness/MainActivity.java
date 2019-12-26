package com.example.gymfitness;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
<<<<<<< HEAD
import android.content.SharedPreferences;
import android.database.Cursor;
=======
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
<<<<<<< HEAD
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.*;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
=======
import android.widget.Toast;
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a

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
<<<<<<< HEAD
    private String COLUMN_NAME_GENERO;
    private int genero;
    private String QUERY_GENERO = "SELECT " + configurationDB.genero._ID + " FROM " + configurationDB.genero.TABLE_NAME + " WHERE " + configurationDB.genero.COLUMN_NAME_GENERO + " = ?";
    private RequestQueue requestQueQue;
    private String url;
    private String usuario;
    private Button button;
    public static  String varGlobal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        configuracionesGlobales();
        //Revisamos si existe alguna peticion para agregar un registro a la db
        if (getIntent().getBooleanExtra("estado", estadoRegistro)) {
            COLUMN_NAME_NUSUARIO = getIntent().getStringExtra("usuario");
            COLUMN_NAME_NOMBRE = getIntent().getStringExtra("nombre");
            COLUMN_NAME_APE_PAT = getIntent().getStringExtra("apellidoPat");
=======


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
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
            COLUMN_NAME_APE_MAT = getIntent().getStringExtra("apellidoMat");
            COLUMN_NAME_FECHANAC = getIntent().getStringExtra("fechaNac");
            COLUMN_NAME_FECHAING = getIntent().getStringExtra("fechaIng");
            COLUMN_NAME_CLAVE = getIntent().getStringExtra("clave");
<<<<<<< HEAD
            COLUMN_NAME_GENERO = getIntent().getStringExtra("genero");
            genero = busquedaSQLGenero(QUERY_GENERO, COLUMN_NAME_GENERO);
            insertar(COLUMN_NAME_NUSUARIO, COLUMN_NAME_NOMBRE, COLUMN_NAME_APE_PAT, COLUMN_NAME_APE_MAT, COLUMN_NAME_FECHANAC, COLUMN_NAME_FECHAING, COLUMN_NAME_CLAVE, genero, this);
            insertaRegistro insertaRegistro = new insertaRegistro(COLUMN_NAME_NUSUARIO, COLUMN_NAME_NOMBRE, COLUMN_NAME_APE_PAT, COLUMN_NAME_APE_MAT, COLUMN_NAME_CLAVE, COLUMN_NAME_FECHANAC, COLUMN_NAME_FECHAING, genero, getApplicationContext());
        }
        button = (Button) findViewById(R.id.button);
        requestQueQue = Volley.newRequestQueue(getApplicationContext());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = (TextInputEditText) findViewById(R.id.inputUser);
                password = (TextInputEditText) findViewById(R.id.inputPassword);
                if (user.getText().toString().trim().equals("")) {
                    user.setError("Favor de rellenar con un usuario valido.");
                } else if (password.getText().toString().equals("")) {
                    password.setError("Favor de rellenar con una contraseña valida.");
                } else {





                    BusquedaCuenta(user.getText().toString(),password.getText().toString());
                    usuario = null;




                }
            }
        });
=======

            insertar(COLUMN_NAME_NUSUARIO,COLUMN_NAME_NOMBRE,COLUMN_NAME_APE_PAT,COLUMN_NAME_APE_MAT,COLUMN_NAME_FECHANAC,COLUMN_NAME_FECHAING,COLUMN_NAME_CLAVE,this);

        }

>>>>>>> 69a165b919189b08b045645f5f1144351088c78a

    }


<<<<<<< HEAD

    public void registrarCuenta(View view) {
        Intent intent = new Intent(this, registro.class);
=======
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
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        startActivity(intent);
    }


<<<<<<< HEAD
    public void configuracionesGlobales() {
=======
    public void configuracionesGlobales(){
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }


<<<<<<< HEAD
    public void insertar(String usuario, String nombre, String apePat, String apeMat, String fechaNac, String fechaIng, String clave, int IDgenero, Context context) {
        dbHelper dbHelper = new dbHelper(getApplicationContext(), configurationDB.DATABASE_NAME, null, configurationDB.DATABASE_VERSION);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        if (db != null) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(configurationDB.usuario.COLUMN_NAME_NUSUARIO, usuario);
            contentValues.put(configurationDB.usuario.COLUMN_NAME_CLAVE, clave);
            contentValues.put(configurationDB.usuario.COLUMN_NAME_NOMBRE, nombre);
            contentValues.put(configurationDB.usuario.COLUMN_NAME_APE_PAT, apePat);
            contentValues.put(configurationDB.usuario.COLUMN_NAME_APE_MAT, apeMat);
            contentValues.put(configurationDB.usuario.COLUMN_NAME_FECHANAC, fechaNac);
            contentValues.put(configurationDB.usuario.COLUMN_NAME_GENERO, IDgenero);
            contentValues.put(configurationDB.usuario.COLUMN_NAME_FECHAING, fechaIng);
            long nFilas = db.insert(configurationDB.usuario.TABLE_NAME, null, contentValues);
            Toast.makeText(this, "Felicidades! registro con exito.", Toast.LENGTH_SHORT).show();
=======
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
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
            db.close();
        }
    }

<<<<<<< HEAD

    public int busquedaSQLGenero(String query, String Genero) {
        int id = 0;
        dbHelper db = new dbHelper(getApplicationContext(), configurationDB.DATABASE_NAME, null, configurationDB.DATABASE_VERSION);
        SQLiteDatabase sql = db.getReadableDatabase();
        String[] args = {Genero};
        if (sql != null) {
            Cursor c = sql.rawQuery(query, args);
            if (c.moveToFirst()) {
                id = c.getInt(0);
            }
            db.close();
        }
        return id;

    }

    public void  BusquedaCuenta(String lUser,String lPassword) {
        datosSolicitud datosSolicitud = new datosSolicitud();
        final ArrayList<String> lista = new ArrayList<>();
            url = "http://"+datosSolicitud.getIp()+"/webService/comprobarUser.php?"+datosSolicitud.getUsuario()+"="+lUser+"&"+datosSolicitud.getClave()+"="+lPassword;

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("persona");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject persona = jsonArray.getJSONObject(i);
                        usuario = persona.getString("usuario");

                    }


                } catch (JSONException e) {
                    Toast.makeText(getApplicationContext(), "" + e, Toast.LENGTH_SHORT);
                }
            }
        }
        , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "" + error, Toast.LENGTH_SHORT);
            }
        });

        requestQueQue.add(jsonObjectRequest);
        requestQueQue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
            @Override
            public void onRequestFinished(Request<Object> request) {
               if(usuario!=null){
                   Intent intent = new Intent(getApplicationContext(),agEvaluacion.class);

                   SharedPreferences.Editor editor = getSharedPreferences(varGlobal,MODE_PRIVATE).edit();
                   editor.putString("usuario",usuario);
                   editor.commit();
                   startActivity(intent);
               }
               else{
                   Toast.makeText(getApplicationContext(),"Usuario/password incorrectos.",Toast.LENGTH_SHORT).show();
               }
            }
        });

    }




=======
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
}
