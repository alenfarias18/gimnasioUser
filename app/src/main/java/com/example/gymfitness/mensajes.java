package com.example.gymfitness;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

public class mensajes {
    public mensajes(){

    }


    public void  Mcancelar(final Activity e,String cuerpo,String titulo){
        AlertDialog.Builder builder = new AlertDialog.Builder(e);
        builder.setMessage(cuerpo);
        builder.setTitle(titulo);


        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setPositiveButton("SI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                e.finish();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}

