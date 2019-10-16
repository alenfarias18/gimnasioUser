package com.example.gymfitness;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

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

    public buscarEvaluacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view =inflater.inflate(R.layout.fragment_buscar_evaluacion, container, false);



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
                    Fragment fragment2 = new visualizarEvaluacion();
                    FragmentManager miManejador = getFragmentManager();
                    FragmentTransaction miTransaccion  = miManejador.beginTransaction();

                    miTransaccion.replace(R.id.IDFragmentAdd,fragment2,"1");

                    miTransaccion.commit();
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


}
