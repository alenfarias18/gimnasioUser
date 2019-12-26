package com.example.gymfitness;


<<<<<<< HEAD

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
=======
<<<<<<< HEAD
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
=======
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
<<<<<<< HEAD
=======
import android.support.v4.app.FragmentActivity;
>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
=======
import java.util.Calendar;
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a


/**
 * A simple {@link Fragment} subclass.
 */
public class register3 extends Fragment {

    Calendar calendario = Calendar.getInstance();
<<<<<<< HEAD

=======
<<<<<<< HEAD
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
    final int anio = calendario.get(Calendar.YEAR);
    final int mes = calendario.get(Calendar.MONTH);
    final int dia = calendario.get(Calendar.DAY_OF_MONTH);
    private RadioButton rb1;
    private RadioButton rb2;
    private TextInputEditText fechaNacimiento;

<<<<<<< HEAD

    private String sexo = "";
    private String Femenino = "Femenino";
    private  String Masculino = "Masculino";
    private String fechaNac = "";

=======
=======
    final  int anio = calendario.get(Calendar.YEAR);
    final  int mes = calendario.get(Calendar.MONTH);
    final  int dia = calendario.get(Calendar.DAY_OF_MONTH);
    private RadioButton rb1;
    private RadioButton rb2;
    TextInputEditText fechaNacimiento;
    private String sexo = "";
    private String Femenino = "F";
    private  String Masculino = "M";
    private String fechaNac = "";
>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e

    public register3() {
        // Required empty public constructor
    }

<<<<<<< HEAD
=======
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }
>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View vista =  inflater.inflate(R.layout.fragment_register3, container, false);
<<<<<<< HEAD

=======
        NumberPicker picker = (NumberPicker)vista.findViewById(R.id.picker);
        picker.setMinValue(50);
        picker.setMaxValue(200);
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a





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
<<<<<<< HEAD



=======
<<<<<<< HEAD
=======

>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        final TextView text = (TextView)vista.findViewById(R.id.textView13);

        //boton
        Button aceptar = (Button)vista.findViewById(R.id.button2);
        aceptar.setOnClickListener(new View.OnClickListener() {
<<<<<<< HEAD

=======
<<<<<<< HEAD
=======




>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
            @Override
            public void onClick(View v) {
                if(fechaNacimiento.getText().toString().trim().equals("")){
                    fechaNacimiento.setError("Favor de ingresar una fecha de nacimiento valida");
                }
                else if(!rb1.isChecked() && !rb2.isChecked()){
                    text.setError("Favor de seleccionar un sexo.");
                }
                else{
<<<<<<< HEAD

=======
<<<<<<< HEAD


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

=======
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
                    fechaNac = fechaNacimiento.getText().toString();
                    if(rb1.isChecked()){
                        sexo = Femenino;
                    }
                    else{
                        sexo = Masculino;
                    }

<<<<<<< HEAD
=======

>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
                    //Recuperamos todos los datos enviados por el fragment anterior
                    Bundle bundle = getArguments();
                    String usuario = bundle.getString("usuario");
                    String password = bundle.getString("password");
                    String nombre = bundle.getString("nombre");
<<<<<<< HEAD
                    String apellidoM = bundle.getString("apellidoM");
                    String apellidoP = bundle.getString("apellidoP");
                    String fechaNacimiento = fechaNac;
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                    Date date = new Date();
                    String fechaIngreso = dateFormat.format(date);

                    //Le pasamos a la clase registroDB los valores obtenidos en todos los fragments.


                   Intent intent = new Intent(getActivity(),MainActivity.class);
                    intent.putExtra("estado",true);
                    intent.putExtra("usuario",usuario);
                    intent.putExtra("nombre",nombre);
                    intent.putExtra("apellidoPat",apellidoP);
                    intent.putExtra("apellidoMat",apellidoM);
                    intent.putExtra("fechaNac",fechaNacimiento);
                    intent.putExtra("fechaIng",fechaIngreso);
                    intent.putExtra("clave",password);
                    intent.putExtra("genero",sexo);
                    startActivity(intent);

                }






=======
                    String apellidoM = bundle.getString("apellidom");
                    String apellidoP = bundle.getString("apellidop");
                    String fechaNacimiento = fechaNac;

                    //llamamos a la configuracion para obtener la version y el nombre de esta (DB)

                    configuracionDB configuracionDB = new configuracionDB();
                    dbHelper dbHelper = new dbHelper(getActivity(),configuracionDB.DATABASE_NAME,null,configuracionDB.DATABASE_VERSION);
                    SQLiteDatabase DB = dbHelper.getWritableDatabase();



                   if(DB!=null){
                        configuracionDB.registro registro = new configuracionDB.registro() ;
                        ContentValues valores = new ContentValues();
                        valores.put(registro.COLUMN_NAME_USUARIO,usuario);
                        valores.put(registro.COLUMN_NAME_PASSWORD,password);
                        valores.put(registro.COLUMN_NAME_NOMBRE,nombre);
                        valores.put(registro.COLUMN_NAME_APELLIDOP,apellidoP);
                        valores.put(registro.COLUMN_NAME_APELLIDOM,apellidoM);
                        valores.put(registro.COLUMN_NAME_FECHA_NACIMIENTO,fechaNacimiento);
                        valores.put(registro.COLUMN_NAME_GENERO,sexo);
                        valores.put(registro.COLUMN_NAME_FECHA_INGRESO,"aun no configurada");
                        long i = DB.insert("tblRegistro",null,valores);
                        if(i>0){
                            Toast.makeText(vista.getContext(),"Registro completado",Toast.LENGTH_LONG).show();
                        }
                        else{
                            Toast.makeText(vista.getContext(),"Ha ocurrido un error al insertar.",Toast.LENGTH_LONG).show();
                        }
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
                    }



<<<<<<< HEAD



=======
                }
>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e
            }
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        });






        return vista;
    }

<<<<<<< HEAD



=======
<<<<<<< HEAD


=======
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);
    }
<<<<<<< HEAD

=======
>>>>>>> 80d37b9733323f62268fa0f9804d1e96ef681e5e
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a


        public void obtenerFecha(View vista){
            DatePickerDialog date = new DatePickerDialog(vista.getContext(), new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    int cero = 0;
                    final int mes2 = month+1;
<<<<<<< HEAD
                    String diaFormato = (dayOfMonth<9)?cero+String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                    String mesFormato = (mes<9)?cero+String.valueOf(mes2):String.valueOf(mes2);
                    fechaNacimiento.setText(year+"-"+mesFormato+"-"+diaFormato);
=======
                    String diaFormato = (dayOfMonth<10)?cero+String.valueOf(dayOfMonth):String.valueOf(dayOfMonth);
                    String mesFormato = (mes<10)?cero+String.valueOf(mes2):String.valueOf(mes2);
                    fechaNacimiento.setText(diaFormato+"/"+mesFormato+"/"+year);
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a

                }
            },anio,mes,dia);
            date.show();
        }

    }
