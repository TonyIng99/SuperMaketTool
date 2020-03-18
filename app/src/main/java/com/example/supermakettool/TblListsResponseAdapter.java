package com.example.supermakettool;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class TblListsResponseAdapter extends BaseAdapter {

    private List<TblListsResponse> mData;
    private Context mContext;

    public TblListsResponseAdapter(Context context, List<TblListsResponse> list) {
        mData = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(final int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = View.inflate(mContext, android.R.layout.simple_list_item_1, null);
        TblListsResponse p = mData.get(position);
        ((TextView)rowView.findViewById(android.R.id.text1)).
                setText(p.getListName());

        return rowView;

    }
}
