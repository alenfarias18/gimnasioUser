package com.example.gymfitness;


<<<<<<< HEAD
import android.content.SharedPreferences;
=======
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class agEvaluacion extends AppCompatActivity implements ComunicaButton{
private int fragment = -1;
<<<<<<< HEAD
private String usuario;
=======

>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ag_evaluacion);
<<<<<<< HEAD


        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.varGlobal, MODE_PRIVATE);
        usuario = sharedPreferences.getString("usuario", "");


=======
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        menu(0);
        llamadaFragment();
        configuracionesGlobales();

    }


    public void llamadaFragment(){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.idFragmentNvegacion, new Navegacion());
        ft.commit();

    }


    public void llamadaFragmentSearch(){

            sacarFragment();

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.IDFragmentAdd, new buscarEvaluacion(),"1");
        ft.commit();

    }
    public void llamadaFragmentList(){

            sacarFragment();

<<<<<<< HEAD


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.IDFragmentAdd, new listEvaluacion(),"2" );

=======
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.IDFragmentAdd, new listEvaluacion(),"2" );
>>>>>>> 69a165b919189b08b045645f5f1144351088c78a
        ft.commit();

    }
    public void sacarFragment(){
        String tag = "";
        if(fragment==0){
            tag = "1";
        }
        else if(fragment == 1){
            tag = "2";
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(tag);
        if(fragment != null)
            getSupportFragmentManager().beginTransaction().remove(fragment).commit();
    }



    @Override
    public void menu(int BotonPresionado) {

      if(BotonPresionado == 0){
            llamadaFragmentSearch();

            fragment = BotonPresionado;
        }
        else if(BotonPresionado == 1){
            llamadaFragmentList();

            fragment = BotonPresionado;
        }
    }

    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }

}
