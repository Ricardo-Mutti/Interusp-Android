package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.mutti.interusp_android.Model.PontuacaoModalidade;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;

/**
 * Created by Victor on 01/05/2016.
 */
public class PontuacaoModalidadeAdapter extends ArrayAdapter<PontuacaoModalidade> {

    Context context;
    ArrayList<PontuacaoModalidade> list;

    public PontuacaoModalidadeAdapter(Context context, ArrayList<PontuacaoModalidade> list) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            convertView = inflater.inflate(R.layout., null);
        }

        return convertView;
    }
}
