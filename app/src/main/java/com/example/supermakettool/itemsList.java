package com.example.supermakettool;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class itemsList extends AppCompatActivity {

    private ListView listitems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        // Obtener datos de la clase Lists.java
        Bundle parametros = this.getIntent().getExtras();
        if(parametros !=null){
            int position = parametros.getInt("position");
        }

        listitems = (ListView) findViewById(R.id.lv_items);

        String[][] datos = {
                {"Leche", "1", "249", "L",},
                {"Huevito", "2", "217", "KG",},
                {"Pan", "2", "201", "PZA",},
        };

        listitems.setAdapter(new itemListAdapter(this, datos));

        listitems.setClickable(true);
        listitems.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                //Object o = listView.getItemAtPosition(position);
                // Realiza lo que deseas, al recibir clic en el elemento de tu listView determinado por su posicion.
                Log.i("Click", "click en el elemento " + position + " de mi ListView");

                Intent siguiente = new Intent(itemsList.this, itemsList.class);
                Bundle extras = new Bundle();
                extras.putInt("position", position);
                onPause();
                startActivity(siguiente);


            }
        });

    }


}
