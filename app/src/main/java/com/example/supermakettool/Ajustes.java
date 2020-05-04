package com.example.supermakettool;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

public class Ajustes extends AppCompatActivity {

    RelativeLayout r;
    Spinner s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustes);

        s = (Spinner)findViewById(R.id.spinner3);

        String[] items = {
                "Fondo 1",
                "Fondo 2",
                "Fondo 3",
                "Fondo 4",

        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String strSelected = s.getSelectedItem().toString();
                if(strSelected=="Fondo 1")
                {
                    r.setBackgroundResource(R.drawable.celeste);
                }
                else if(strSelected=="Fondo 2")
                    {
                        r.setBackgroundResource(R.drawable.fondo1);
                    }
                    else if(strSelected=="Fondo 3")
                        {
                            r.setBackgroundResource(R.drawable.fondo2);
                        }
                        else if(strSelected=="Fondo 4")
                            {
                                r.setBackgroundResource(R.drawable.fondo3);
                            }
                        }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
