package com.example.supermakettool;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class Ajustes extends AppCompatActivity {

    public int vl_background;
    Spinner s;
    RelativeLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        layout = (RelativeLayout)  findViewById(R.id.id_activity_ajustes);
        int i_id = ((ClaseGlobal) getApplication()).getId_backround();
        layout.setBackgroundResource(i_id);

        s = (Spinner) findViewById(R.id.spinner3);

        String[] items = {
                "Fondo 1",
                "Fondo 2",
                "Fondo 3",
                "Fondo 4",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSelected = s.getSelectedItem().toString();


                switch (strSelected) {
                    case "Fondo 1":
                        vl_background = R.drawable.celeste;
                        break;

                    case "Fondo 2":
                        vl_background = R.drawable.fondo1;
                        break;

                    case "Fondo 3":
                        vl_background = R.drawable.fondo2;
                        break;

                    case "Fondo 4":
                        vl_background = R.drawable.fondo3;
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void getSettings(View view) {
        ((ClaseGlobal) getApplication()).setId_backround(vl_background);
        Intent siguiente = new Intent(Ajustes.this, PantallaPrincipal.class);
        startActivity(siguiente);
    }
}
