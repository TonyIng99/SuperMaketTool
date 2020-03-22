package com.example.supermakettool;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.jetbrains.annotations.NotNull;


public class Lists extends AppCompatActivity {

    public String res;
    private ListView listview;
    private ArrayList<String> names;
    private ArrayAdapter<String> adapter;


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
                showInputBox("Nuena Lista", 1);
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
                .url("https://supermarkettoolswebapi.azurewebsites.net/TblLists/1")
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
            names.add(arraylist[0].getListName());

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
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

        listview.setLongClickable(true);
        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,int pos, long id) {


                Log.v("long clicked","pos: " + pos);

                new AlertDialog.Builder(Lists.this)
                        .setTitle("Title")
                        .setMessage(R.string.Confirm_message)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                Toast.makeText(Lists.this, "Yaay", Toast.LENGTH_SHORT).show();

                            }})
                        .setNegativeButton(android.R.string.no, null).show();

                return true;
            }
        });

    }

    public void showInputBox(String oldItem, final int index) {
        final Dialog dialog = new Dialog(Lists.this);
        dialog.setTitle("Input Box");
        dialog.setContentView(R.layout.input_box);
        TextView txtMessage = (TextView) dialog.findViewById(R.id.txtmessage);
        txtMessage.setText(R.string.texto_titulo_input_box);
        txtMessage.setTextColor(Color.parseColor("#ff2222"));
        final EditText editText = (EditText) dialog.findViewById(R.id.txtinput);
        editText.setText(oldItem);
        Button bt = (Button) dialog.findViewById(R.id.btdone);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                names.set(index, editText.getText().toString());
                adapter.notifyDataSetChanged();
                dialog.dismiss();
            }
        });

        dialog.show();

    }

}
