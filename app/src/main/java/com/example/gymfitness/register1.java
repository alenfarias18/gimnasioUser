package com.example.gymfitness;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;


public class register1 extends Fragment {


    public register1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

                final View vista = inflater.inflate(R.layout.fragment_register1, container, false);

                //Barra de progreso
                ProgressBar barra = (ProgressBar)vista.findViewById(R.id.progressBar);
                com.example.gymfitness.ProgressBar progress = new com.example.gymfitness.ProgressBar(barra);
                progress.incrementa(33);


                Button next = vista.findViewById(R.id.button5);
                next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextInputEditText user = (TextInputEditText)vista.findViewById(R.id.inputUser);
                TextInputEditText password = (TextInputEditText)vista.findViewById(R.id.inputPassword);
                TextInputEditText password2 = (TextInputEditText)vista.findViewById(R.id.inputPassword2);



                if(user.getText().toString().trim().equals("")){
                    user.setError("Favor de rellenar con un usuario valido.");
                }
                else if(password.getText().toString().equals("")){
                    password.setError("Favor de rellenar con una contraseña valida.");
                }
                else if(password.getText().toString().length()<4){
                    password.setError("Favor de ingresar una contraseña con un minino de 4 caracteres.");
                }
                else if(password.getText().toString().length()>20){
                    password.setError("Favor de ingresar una contraseña con un maximo de 20 caracteres.");
                }
                else if(!password.getText().toString().equals(password2.getText().toString())){
                    password.setError("Las contraseñas ingresadas no coinciden.");
                }
                else{

                        if(consultaSQL(user.getText().toString())>0){
                            Toast.makeText(getContext(),"Este nombre de usuario ya esta en uso.",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Fragment fragment2 = new register2();
                            FragmentManager miManejador = getFragmentManager();
                            FragmentTransaction miTransaccion  = miManejador.beginTransaction();

                            miTransaccion.replace(R.id.idFragmentModifica,fragment2);

                            miTransaccion.commit();
                        }





                }
            }
        });




        return vista;


    }
        public int consultaSQL(String user) {
            int cantidad = 0;
            dbHelper db = new dbHelper(getActivity(), configurationDB.DATABASE_NAME, null, configurationDB.DATABASE_VERSION);
            SQLiteDatabase sql = db.getReadableDatabase();
            String[] args = {user};
            if (sql != null) {
                Cursor c = sql.rawQuery("SELECT * FROM " + configurationDB.usuario.TABLE_NAME + " WHERE " + configurationDB.usuario.COLUMN_NAME_NUSUARIO + " = ?", args);
                cantidad = c.getCount();}
                return cantidad;
            }
        }
