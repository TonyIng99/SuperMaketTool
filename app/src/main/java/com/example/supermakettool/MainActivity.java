package com.example.supermakettool;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    EditText et_usuario, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_usuario = findViewById(R.id.editText);
        et_password = findViewById(R.id.editText2);

    }
    public void Registrar(View view)
    {
        Intent registrar = new Intent(this, Registro.class);
        startActivity(registrar);
    }
    public void Principal(View view)
    {
        Intent principal = new Intent(this, PantallaPrincipal.class );
        startActivity(principal);

        final String username = et_usuario.getText().toString();
        final String password = et_password.getText().toString();
        
       // LoginRequest loginRequest = new LoginRequest(username, password, responsseListener);
       // RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
       // queue.add(loginRequest);
    }

}
