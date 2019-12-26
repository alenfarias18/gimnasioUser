package com.example.gymfitness;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
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


/**
 * A simple {@link Fragment} subclass.
 */
public class listEvaluacion extends Fragment {
    private RequestQueue requestQueQue;
    private String url;
    private  ListView list;
    private String usuario;
    private String fecha,peso,estatura,medidaCintura,imc,indiceGrasa,grasaInstrumento;
    private ArrayAdapter arrayAdapter;
    public listEvaluacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_list_evaluacion, container, false);
        list = (ListView)view.findViewById(R.id.ListViewEliminar);
        requestQueQue = Volley.newRequestQueue(view.getContext());
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(MainActivity.varGlobal, getActivity().MODE_PRIVATE);




        usuario = sharedPreferences.getString("usuario", "");

        cargarDatos(view,usuario);
        //BUSCADOR
        TextInputEditText buscador = (TextInputEditText)view.findViewById(R.id.buscador);
        buscador.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

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

        return view;
    }
    private void cargarDatos(final View view,String usuario){

        requestQueQue = Volley.newRequestQueue(view.getContext());



        datosSolicitud datosSolicitud = new datosSolicitud();
        url = "http://"+datosSolicitud.getIp()+"/webService/buscarEvaluaciones.php?"+datosSolicitud.getUsuario()+"="+usuario;
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

                        lista.add(fecha);

                    }
                     arrayAdapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1,lista);


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
