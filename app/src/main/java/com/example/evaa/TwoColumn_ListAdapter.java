package com.example.evaa;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TwoColumn_ListAdapter extends ArrayAdapter<Item> {

    private LayoutInflater mInflater;
    private ArrayList<Item> items;
    private int mViewResourceId;

    public TwoColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<Item> items) {
        super(context, textViewResourceId, items);
        this.items = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parents) {
        convertView = mInflater.inflate(mViewResourceId,null);

        Item item = items.get(position);

        if (item != null) {
            TextView itemName = (TextView) convertView.findViewById(R.id.itemName);
            TextView itemDate = (TextView) convertView.findViewById(R.id.itemDate);

            if (itemDate != null) {
                itemDate.setText((item.getItemDate()));
            }
            if (itemName != null) {
                itemName.setText((item.getItemName()));
            }

        }
        return convertView;
    }
}
