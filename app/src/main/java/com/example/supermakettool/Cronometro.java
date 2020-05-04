package com.example.supermakettool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;

public class Cronometro extends AppCompatActivity {

    private TextView textoCronometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronometro);

        textoCronometro = (TextView) findViewById(R.id.cronometro);

        Button startButton = (Button) findViewById(R.id.button4);
        startButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                iniciarCronometro();
            }
        });

        Button stopButton = (Button) findViewById(R.id.button5);
        stopButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                pararCronometro();
            }
        });

        Crono.setUpdateListener(this);

    }
    @Override
    protected void onDestroy() {
        // Antes de cerrar la aplicacion se para el servicio (el cronometro)
        pararCronometro();
        super.onDestroy();
    }

    /**
     * Inicia el servicio
     */
    private void iniciarCronometro() {
        Intent service = new Intent(this, Crono.class);
        startService(service);
    }

    /**
     * Finaliza el servicio
     */
    private void pararCronometro() {
        Intent service = new Intent(this, Crono.class);
        stopService(service);
    }

    /**
     * Actualiza en la interfaz de usuario el tiempo cronometrado
     *
     * @param tiempo
     */
    public void actualizarCronometro(double tiempo) {
        textoCronometro.setText(String.format("%.2f", tiempo) + "s");
    }
}