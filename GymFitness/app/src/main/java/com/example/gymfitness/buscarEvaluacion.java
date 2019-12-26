package com.example.gymfitness;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class buscarEvaluacion extends Fragment {
private TextInputEditText desde;
    private TextInputEditText hasta;
Calendar calendario = Calendar.getInstance();
final int anio = calendario.get(Calendar.YEAR);
final int mes = calendario.get(Calendar.MONTH);
final int dia = calendario.get(Calendar.DAY_OF_MONTH);
    private RequestQueue requestQueQue;
    private String url;
    private  ListView list;
    private String usuario;
    private String fecha,peso,estatura,medidaCintura,imc,indiceGrasa,grasaInstrumento;
    public buscarEvaluacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_buscar_evaluacion, container, false);

        list = (ListView)view.findViewById(R.id.ListViewEliminar2);

        //Desde
        desde = (TextInputEditText) view.findViewById(R.id.desde);

        desde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha(view,desde);
            }
        });

        //hasta
        hasta = (TextInputEditText) view.findViewById(R.id.hasta);

        hasta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha(view,hasta);
            }
        });


        //boton

        Button buscar = (Button)view.findViewById(R.id.button3);
        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(desde.getText().toString().trim().equals("")){
                    desde.setError("Favor de ingresar una fecha de inicio.");
                }
                else if(hasta.getText().toString().trim().equals("")){
                    hasta.setError("Favor de ingresar una fecha de termino.");
                }
                else{
                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MainActivity.varGlobal, getActivity().MODE_PRIVATE);
                    usuario = sharedPreferences.getString("usuario", "");
                     cargarDatos(view,usuario);
                    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            Intent intent = new Intent(getActivity(),vizualizaEva.class);
                            intent.putExtra("fecha",fecha);
                            intent.putExtra("peso",peso);
                            intent.putExtra("estatura",estatura);
                            intent.putExtra("medidaCintura",medidaCintura);
                            intent.putExtra("imc",imc);
                            intent.putExtra("indiceGrasa",indiceGrasa);
                            intent.putExtra("grasaInstrumento",grasaInstrumento);
                            startActivity(intent);
                        }
                    });
                }
            }
        });


        return view;
    }



    public void obtenerFecha(View vista, final TextInputEditText text){
        DatePickerDialog date = new DatePickerDialog(vista.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int cero = 0;
                final int mes2 = month+1;
                String diaFormato = (dayOfMonth<10)?cero+String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                String mesFormato = (mes<10)?cero+String.valueOf(mes2):String.valueOf(mes2);
                text.setText(diaFormato+"/"+mesFormato+"/"+year);

            }
        },anio,mes,dia);
        date.show();
    }


    private void cargarDatos(final View view,String usuario){

        requestQueQue = Volley.newRequestQueue(view.getContext());



        datosSolicitud datosSolicitud = new datosSolicitud();
        url = "http://"+datosSolicitud.getIp()+"/webService/buscarEvaluaciones.php?"+datosSolicitud.getUsuario()+"="+usuario+"&fecha1='"+desde.getText().toString()+"'&fecha2='"+hasta.getText().toString()+"'";
        JsonObjectRequest jsonObjectRequest = new    JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("evaluaciones");
                    ArrayList<String> lista = new ArrayList<>();

                    for(int i = 0; i<jsonArray.length();i++){
                        JSONObject persona = jsonArray.getJSONObject(i);
                        fecha = persona.getString("fecha");
                        estatura = persona.getString("estatura");
                        peso = persona.getString("peso");
                        medidaCintura = persona.getString("medidaCintura");
                        indiceGrasa = persona.getString("PorcentajeGrasaFormula");
                        imc = persona.getString("imc");
                        grasaInstrumento = persona.getString("indiceGrasaInstrumento");

                        lista.add(i+") fecha: "+fecha);

                    }

                    ArrayAdapter arrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1,lista);
                    list.setAdapter(arrayAdapter);
                } catch (JSONException e) {
                    Toast.makeText(view.getContext(),"j"+e,Toast.LENGTH_SHORT);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(view.getContext(),"j"+error,Toast.LENGTH_SHORT);
            }
        });

        requestQueQue.add(jsonObjectRequest);

    }


}
