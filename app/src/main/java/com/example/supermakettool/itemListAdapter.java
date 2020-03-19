package com.example.supermakettool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class itemListAdapter extends BaseAdapter {

    public static LayoutInflater inflater = null;

    Context context;

    public itemListAdapter(){

        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View view = inflater.inflate(R.layout.itemview, null);

        TextView product = (TextView) view.findViewById(R.id.tv_product);
        TextView quantity = (TextView) view.findViewById(R.id.tv_quantity);
        TextView product = (TextView) view.findViewById(R.id.tv_pice);
        TextView product = (TextView) view.findViewById(R.id.tv_um);

        


        return null;
    }
}
