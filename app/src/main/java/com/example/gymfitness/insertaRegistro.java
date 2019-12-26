package com.example.gymfitness;

import android.content.Context;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONObject;

public class insertaRegistro  implements Response.Listener<JSONObject>,Response.ErrorListener {
    private String usuario;
    private String nombre;
    private String apellidoPat;
    private String apellidoMat;
    private String clave;
    private String fechaNacimiento;
    private String fechaIngreso;
    private int genero;
    private JsonObjectRequest JsonObjectRequest;
    private RequestQueue request;
    private Context context;

    public insertaRegistro(String usuario, String nombre, String apellidoPat, String apellidoMat,String clave,String fechaNacimiento,String fechaIngreso,int genero,Context context){
        this.usuario = usuario;
        this.nombre = nombre;
        this.apellidoPat = apellidoPat;
        this.apellidoMat = apellidoMat;
        this.clave = clave;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaIngreso = fechaIngreso;
        this.genero = genero;
        this.context = context;
        request = Volley.newRequestQueue(context);
        insertaDatos();

    }

    public void insertaDatos(){
        datosSolicitud datosSolicitud = new datosSolicitud();
        String url = "http://"+datosSolicitud.getIp()+":"+datosSolicitud.getPort()+"/GymFitness/registro?"+datosSolicitud.getUsuario()+"="+usuario+"&"+datosSolicitud.getNombre()+"="+nombre+"&"+datosSolicitud.getApellidoPat()+"="+apellidoPat+"&"+datosSolicitud.getApellidoMat()+"="+apellidoMat+"&"+datosSolicitud.getClave()+"="+clave+"&"+datosSolicitud.getFechaNac()+"="+fechaNacimiento+"&"+datosSolicitud.getFechaIng()+"="+fechaIngreso+"&"+datosSolicitud.getGenero()+"="+String.valueOf(genero);
        JsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,null,this,this);
        request.add(JsonObjectRequest);

    }


    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(JSONObject response) {

    }
}
