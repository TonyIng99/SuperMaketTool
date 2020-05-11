package com.example.supermakettool;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


public class PantallaPrincipal extends AppCompatActivity {

    private TextView opciones;
    private TextView cronometro;
    private TextView jugar;
    private TextView supermarkettool;
    private TextView canasta;
    private Typeface restaurantmenu;
    ConstraintLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_principal);

        String fuente1 = "fuentes/fullpack.ttf";
        this.restaurantmenu = Typeface.createFromAsset(getAssets(),fuente1);

        layout = (ConstraintLayout)  findViewById(R.id.activity_pantalla_principal);
        int i_id = ((ClaseGlobal) getApplication()).getId_backround();
        layout.setBackgroundResource(i_id);

        supermarkettool = (TextView) findViewById(R.id.textView);
        supermarkettool.setTypeface(restaurantmenu);

        canasta = (TextView) findViewById(R.id.button9);
        canasta.setTypeface(restaurantmenu);


        jugar = (TextView) findViewById(R.id.button10);
        jugar.setTypeface(restaurantmenu);

        cronometro = (TextView) findViewById(R.id.button11);
        cronometro.setTypeface(restaurantmenu);

        opciones = (TextView) findViewById(R.id.button12);
        opciones.setTypeface(restaurantmenu);

    }


    public void Siguiente(View view)
    {
        Intent siguiente = new Intent(PantallaPrincipal.this, Lists.class);
        startActivity(siguiente);
    }
    public void Cronometro(View view)
    {
        Intent cronometro = new Intent(PantallaPrincipal.this, Cronometro.class);
        startActivity(cronometro);
    }
    public void Ajustes(View view)
    {
        Intent ajustes = new Intent(PantallaPrincipal.this, Ajustes.class);
        startActivity(ajustes);
    }
    public void Juego(View view)
    {
        Intent juego = new Intent(PantallaPrincipal.this, juego.class);
        startActivity(juego);
    }
}
