package com.example.gymfitness;


import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

//Aqui se modificaran todas las configuraciones globales (eventos,etc)
public class confiGlobal {
    public confiGlobal(){

    }



    public void noRotar(Activity x){
        x.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }




}



