package com.example.supermakettool;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import android.widget.Toast;

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

                Intent additemsc = new Intent(itemsList.this, AddItem.class);
                onPause();
                startActivity(additemsc);


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
                {"Lechkjhkjhljkhljkjkhe", "1", "249", "L",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevitlnlknlkjno", "2", "217", "KG",},
                {"Huevijkjto", "2", "217", "KG",},
                {"Huevitjbnlllkjytuytruytruytruytrutyro", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Huevito", "2", "217", "KG",},
                {"Pan", "2", "201", "PZA",},
        };

        listitems.setAdapter(new itemListAdapter(this, datos));

        listitems.setLongClickable(true);
        listitems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int pos, long id) {


                Log.v("long clicked","pos: " + pos);

                new AlertDialog.Builder(itemsList.this)
                        .setTitle("Title")
                        .setMessage(R.string.Confirm_message)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(itemsList.this, "Yaay", Toast.LENGTH_SHORT).show();

                            }})
                        .setNegativeButton(android.R.string.no, null).show();

                return true;
            }
        });

    }


}
