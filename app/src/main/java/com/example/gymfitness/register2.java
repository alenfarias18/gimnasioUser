package com.example.gymfitness;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class register2 extends Fragment {


    public register2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final confiGlobal config = new confiGlobal();
        final View vista =  inflater.inflate(R.layout.fragment_register2, container, false);
        final TextInputEditText nombre = (TextInputEditText)vista.findViewById(R.id.inputNombre);
        final TextInputEditText apellidoP = (TextInputEditText)vista.findViewById(R.id.inputApellido);
        final TextInputEditText apellidoM = (TextInputEditText)vista.findViewById(R.id.inputApellidoM);

        //Barra de progreso
        ProgressBar barra = (ProgressBar)vista.findViewById(R.id.progressBar);
        com.example.gymfitness.ProgressBar progress = new com.example.gymfitness.ProgressBar(barra);
        progress.incrementa(66);



        Button next = (Button)vista.findViewById(R.id.button2);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(nombre.getText().toString().trim().equals("")){
                    nombre.setError("Favor de rellenar con un nombre valido.");
                }
                else if(apellidoP.getText().toString().trim().equals("")){
                   apellidoP.setError("Favor de rellenar con un apellido paterno valido.");
                }
                else if(apellidoM.getText().toString().trim().equals("")){
                    apellidoM.setError("Favor de rellenar con un apellido materno valido.");
                }
                else{
                    Fragment fragment2 = new register3();
                    FragmentManager miManejador = getFragmentManager();
                    FragmentTransaction miTransaccion  = miManejador.beginTransaction();

                    miTransaccion.replace(R.id.idFragmentModifica,fragment2);

                    miTransaccion.commit();

                }




            }
        });




        return vista;



    }

}
