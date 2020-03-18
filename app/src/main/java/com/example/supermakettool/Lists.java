package com.example.supermakettool;

import android.os.AsyncTask;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

import android.widget.ArrayAdapter;
import android.widget.ListView;


public class Lists extends AppCompatActivity {

    public String res;
    public boolean flag;
    private ListView listview;
    private ArrayList<String> names;

    public interface GetDataCallback {
        void onGetListData(String List);
        void onError();
    }

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


        get_dataList(1, new GetDataCallback(){
            @Override
            public void onGetListData(String List) {
                res = List;
                flag = true;
            }

            @Override
            public void onError() {
                flag = false;
            }

        });


        Gson gson = new Gson();
        Type collectionType = new TypeToken<ArrayList<TblListsResponse>>(){}.getType();
        Collection<TblListsResponse> enumlist = gson.fromJson(res, collectionType);
        TblListsResponse[] arraylist = enumlist.toArray(new TblListsResponse[enumlist.size()]);
        listview = (ListView) findViewById(R.id.List);
        names = new ArrayList<String>();
        names.add("sxasx");
        names.add("sxasx");
        names.add("sxasx");
        names.add(arraylist[0].getListName());
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
        listview.setAdapter(adapter);

    }


    protected void get_dataList(int user, final GetDataCallback getDataCallback) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://supermarkettoolswebapi.azurewebsites.net/TblLists")
                .method("GET", null)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getDataCallback.onError();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    getDataCallback.onError();
                } else {
                     //res = response.body().string();
                    getDataCallback.onGetListData(response.body().string());
                }
            }
        });
    }


    public void createList(String json){

        if (json != null){
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
        }else {
            listview = (ListView) findViewById(R.id.List);
            names = new ArrayList<String>();
            names.add("Lista Inicial");
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names);
            listview.setAdapter(adapter);
        }

    }

}
