package com.example.gymfitness;




import android.app.AlertDialog;

import android.content.DialogInterface;
import android.os.Bundle;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        llamadaFragment();
        configuracionesGlobales();


    }



    public void iniciarSesion(View view){
       mensajes mensaje = new mensajes();
       mensaje.Mcancelar(this,"¿Estas seguro de volver al inicio?\n" +
               "Se perderán todos los datos ingresados.","¿Ya tienes una cuenta?");

    }

    public void llamadaFragment(){
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.idFragmentModifica, new register1());
        ft.commit();

    }
    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }






}



