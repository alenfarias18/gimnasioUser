package com.example.gymfitness;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class visualizarEvaluacion extends Fragment {


    public visualizarEvaluacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view =  inflater.inflate(R.layout.fragment_visualizar_evaluacion, container, false);

        Button button = (Button)view.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment2 = new buscarEvaluacion();
                FragmentManager miManejador = getFragmentManager();
                FragmentTransaction miTransaccion  = miManejador.beginTransaction();

                miTransaccion.replace(R.id.IDFragmentAdd,fragment2,"1");

                miTransaccion.commit();
            }
        });

        //camara
        CircleImageView btnCamara = (CircleImageView)view.findViewById(R.id.imagec);

        return view;
    }

}
