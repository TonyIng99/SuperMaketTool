package com.example.supermakettool;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jetbrains.annotations.NotNull;


public class Lists extends AppCompatActivity {

    public String res;
    private ListView listview;
    private ArrayList<String> names;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.btn_add_list);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            getApiData();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    void getApiData() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://supermarkettoolswebapi.azurewebsites.net/TblLists")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                // ... check for failure using `isSuccessful` before proceeding
                // Read data on the worker thread
                final String responseData = response.body().string();
                // Run view-related code back on the main thread
                Lists.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        createList(responseData);
                    }
                });
            }
        });

    }


    public void createList(String json){

            Gson gson = new Gson();
            Type collectionType = new TypeToken<ArrayList<TblListsResponse>>(){}.getType();
            Collection<TblListsResponse> enumlist = gson.fromJson(json, collectionType);
            TblListsResponse[] arraylist = enumlist.toArray(new TblListsResponse[enumlist.size()]);

            listview = (ListView) findViewById(R.id.List);
            names = new ArrayList<String>();
            names.add("sxasx");
            names.add("sxasx");
            names.add("sxasx");
            names.add(arraylist[0].getListName());

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
            listview.setAdapter(adapter);


        listview.setClickable(true);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {

                //Object o = listView.getItemAtPosition(position);
                // Realiza lo que deseas, al recibir clic en el elemento de tu listView determinado por su posicion.
                Log.i("Click", "click en el elemento " + position + " de mi ListView");

                Intent siguiente = new Intent(Lists.this, itemsList.class);
                Bundle extras = new Bundle();
                extras.putInt("position", position);
                onPause();
                startActivity(siguiente);


            }
        });

    }

}
