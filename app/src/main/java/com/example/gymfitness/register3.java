package com.example.gymfitness;


import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.Calendar;


/**
 * A simple {@link Fragment} subclass.
 */
public class register3 extends Fragment {

    Calendar calendario = Calendar.getInstance();
    final int anio = calendario.get(Calendar.YEAR);
    final int mes = calendario.get(Calendar.MONTH);
    final int dia = calendario.get(Calendar.DAY_OF_MONTH);
    private RadioButton rb1;
    private RadioButton rb2;
    private TextInputEditText fechaNacimiento;


    public register3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista =  inflater.inflate(R.layout.fragment_register3, container, false);
        NumberPicker picker = (NumberPicker)vista.findViewById(R.id.picker);
        picker.setMinValue(50);
        picker.setMaxValue(200);





        //Barra de progreso
        android.widget.ProgressBar barra = (android.widget.ProgressBar)vista.findViewById(R.id.progressBar);
        com.example.gymfitness.ProgressBar progress = new com.example.gymfitness.ProgressBar(barra);
        progress.incrementa(100);



        //Evento del calendario
        fechaNacimiento = (TextInputEditText ) vista.findViewById(R.id.inputFechaNacimiento);

        fechaNacimiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFecha(vista);
            }
        });

        //sexo
        rb1 = (RadioButton)vista.findViewById(R.id.radioButton3);
        rb2 = (RadioButton)vista.findViewById(R.id.radioButton4);
        final TextView text = (TextView)vista.findViewById(R.id.textView13);

        //boton
        Button aceptar = (Button)vista.findViewById(R.id.button2);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fechaNacimiento.getText().toString().trim().equals("")){
                    fechaNacimiento.setError("Favor de ingresar una fecha de nacimiento valida");
                }
                else if(!rb1.isChecked() && !rb2.isChecked()){
                    text.setError("Favor de seleccionar un sexo.");
                }
                else{


                    //Le pasamos a la clase registroDB los valores obtenidos en todos los fragments.

                    Intent intent = new Intent(getActivity(),MainActivity.class);
                    intent.putExtra("estado",true);
                    intent.putExtra("usuario","usuario3");
                    intent.putExtra("nombre","nombre");
                    intent.putExtra("apellidoPat","apellidoPat");
                    intent.putExtra("apellidoMat","apellidoMat");
                    intent.putExtra("fechaNac","a");
                    intent.putExtra("fechaIng","a");
                    intent.putExtra("clave","a");
                    startActivity(intent);

                }

            }
        });






        return vista;
    }





        public void obtenerFecha(View vista){
            DatePickerDialog date = new DatePickerDialog(vista.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    int cero = 0;
                    final int mes2 = month+1;
                    String diaFormato = (dayOfMonth<10)?cero+String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                    String mesFormato = (mes<10)?cero+String.valueOf(mes2):String.valueOf(mes2);
                    fechaNacimiento.setText(diaFormato+"/"+mesFormato+"/"+year);

                }
            },anio,mes,dia);
            date.show();
        }

    }
