package com.example.gymfitness;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText user;
    private TextInputEditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configuracionesGlobales();

    }


    public void verificaInput(View view){ //Metodo encargado de verificar si los input son rellenados correctamente
         user = (TextInputEditText)findViewById(R.id.inputUser);
         password = (TextInputEditText)findViewById(R.id.inputPassword);
        if(user.getText().toString().trim().equals("")){
            user.setError("Favor de rellenar con un usuario valido.");
        }
        else if(password.getText().toString().equals("")){
            password.setError("Favor de rellenar con una contraseña valida.");
        }
        else{
            //Condicional que sera usado para conectar con la DB y validar si los campos son correctos
            //
            Intent intent = new Intent(this,agEvaluacion.class);
            startActivity(intent);
        }
    }

    public void registrarCuenta(View view){
        Intent intent = new Intent(this,registro.class);
        startActivity(intent);
    }


    public void configuracionesGlobales(){
        confiGlobal config = new confiGlobal();
        config.noRotar(this);
    }

}
