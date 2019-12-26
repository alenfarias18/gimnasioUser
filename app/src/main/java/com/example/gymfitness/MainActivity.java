package com.example.gymfitness;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
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
            COLUMN_NAME_APE_MAT = getIntent().getStringExtra("apellidoMat");
            COLUMN_NAME_FECHANAC = getIntent().getStringExtra("fechaNac");
            COLUMN_NAME_FECHAING = getIntent().getStringExtra("fechaIng");
            COLUMN_NAME_CLAVE = getIntent().getStringExtra("clave");
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

    }



    public void registrarCuenta(View view) {
        Intent intent = new Intent(this, registro.class);
        startActivity(intent);
    }


    public void configuracionesGlobales() {
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }


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
            db.close();
        }
    }


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




}
