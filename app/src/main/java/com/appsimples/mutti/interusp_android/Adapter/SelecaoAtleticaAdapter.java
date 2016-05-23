package com.appsimples.mutti.interusp_android.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Mais.Gritos;
import com.appsimples.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Victor on 04/05/2016.
 */
public class SelecaoAtleticaAdapter extends ArrayAdapter<String> {

    ArrayList<String> list;
    Context context;

    public SelecaoAtleticaAdapter(Context context, ArrayList<String> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final String faculdade = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_atletica, null);
        }

        TextView txtAtletica = (TextView) convertView.findViewById(R.id.txtAtletica);
        txtAtletica.setText(faculdade);

        LinearLayout listItem = (LinearLayout) convertView.findViewById(R.id.listItem);
        listItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Gritos.class);
                intent.putExtra("atletica", faculdade);
                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
