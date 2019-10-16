package com.example.gymfitness;


import android.content.Intent;
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

                    //Recogemos todos los datos y se los enviamos al siguiente fragment
                    Bundle bundle = new Bundle();
                    bundle.putString("usuario",user.getText().toString());
                    bundle.putString("password",password.getText().toString());

                    //Movimiento al siguiente fragment (Fase 2 del registro)
                    Fragment fragment2 = new register2();
                    FragmentManager miManejador = getFragmentManager();
                    FragmentTransaction miTransaccion  = miManejador.beginTransaction();

                    //Cargamos el siguiente fragment con los datos ingresados
                    fragment2.setArguments(bundle);

                    //Cambiamos de fragment
                    miTransaccion.replace(R.id.idFragmentModifica,fragment2);
                    miTransaccion.commit();


                }
            }
        });




        return vista;


    }

}
