package com.example.gymfitness;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class vizualizaEva extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vizualiza_eva);
        EditText fecha = (EditText)findViewById(R.id.editText4);
        EditText peso = (EditText)findViewById(R.id.editText2);
        EditText estatura = (EditText)findViewById(R.id.editText3);
        EditText medidaCintura = (EditText)findViewById(R.id.editText5);
        EditText imc = (EditText)findViewById(R.id.editText6);
        EditText indiceGrasaCorporal = (EditText)findViewById(R.id.editText7);
        EditText grasaInstrumento = (EditText)findViewById(R.id.editText8);
        Bundle datos = this.getIntent().getExtras();

        String Sfecha = datos.getString("fecha");
        fecha.setText(Sfecha);

        String Speso = datos.getString("peso");
        peso.setText(Speso);

        String Sestatura = datos.getString("estatura");
        estatura.setText(Sestatura);

        String SmedidaCintura = datos.getString("medidaCintura");
        medidaCintura.setText(SmedidaCintura);

        String Simc = datos.getString("imc");
        imc.setText(Simc);

        String SindiceGrasa = datos.getString("indiceGrasa");
        indiceGrasaCorporal.setText(SindiceGrasa);

        String SGrasaInstrumento = datos.getString("grasaInstrumento");
        grasaInstrumento.setText(SGrasaInstrumento);



        Button button = (Button)findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),agEvaluacion.class);
                startActivity(intent);
            }
        });

    }
}
