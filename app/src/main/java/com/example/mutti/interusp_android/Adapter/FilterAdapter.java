package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Gabriel on 5/1/16.
 */
public class FilterAdapter extends BaseAdapter {

    Context context;
    ArrayList<String> filters;

    public FilterAdapter (Context context, ArrayList<String> filters) {
        this.context = context;
        this.filters = filters;
    }

    @Override
    public int getCount() {
        return this.filters.size();
    }

    @Override
    public Object getItem(int position) {
        return this.filters.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String filter = (String) getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_filter, null);
        }

        TextView text = (TextView) convertView.findViewById(R.id.filterElement);
        text.setText(filter);

        if (filter.equals("Todos")) {
            text.setTypeface(null, Typeface.BOLD);
        } else {
            text.setTypeface(null, Typeface.NORMAL);
        }

        return convertView;
    }
}
