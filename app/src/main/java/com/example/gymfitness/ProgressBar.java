package com.example.gymfitness;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ProgressBar {
    private android.widget.ProgressBar progress;
    public ProgressBar(android.widget.ProgressBar progress){
        this.progress = progress;
    }

    public void incrementa(int incremento){
        progress.setProgress(incremento);
    }

}
