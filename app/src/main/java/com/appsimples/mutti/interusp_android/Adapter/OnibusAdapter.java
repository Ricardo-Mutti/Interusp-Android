package com.appsimples.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.appsimples.mutti.interusp_android.Model.Onibus;
import com.appsimples.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Mutti on 04/05/16.
 */
public class OnibusAdapter extends BaseAdapter {

        Context context;
        public ArrayList<Onibus> onibuses;

        public OnibusAdapter (Context context, ArrayList<Onibus> onibuses) {
            this.context = context;
            this.onibuses = onibuses;
        }

        @Override
        public int getCount() {
            return this.onibuses.size();
        }

        @Override
        public Object getItem(int position) {
            return this.onibuses.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            Onibus onibus = (Onibus) getItem(position);

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_onibus, null);
            }

            TextView onibus_placa = (TextView) convertView.findViewById(R.id.onibus_placa);
            TextView onibus_informacoes = (TextView) convertView.findViewById(R.id.onibus_informacoes);

            onibus_placa.setText(onibus.getPlaca());
            onibus_informacoes.setText(onibus.getInformacoes());

            return convertView;
        }
    }


