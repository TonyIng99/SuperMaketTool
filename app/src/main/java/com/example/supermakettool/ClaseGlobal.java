package com.example.supermakettool;

import android.app.Application;


public class ClaseGlobal extends Application {

    private int id_user;
    private int id_backround;

    public int getId_backround() {

        if (id_backround == 0){
            id_backround = R.drawable.celeste; //Default background
        }

        return id_backround;
    }

    public void setId_backround(int id_backround) {
        this.id_backround = id_backround;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }
}
