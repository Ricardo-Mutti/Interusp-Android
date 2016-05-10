package com.example.mutti.interusp_android.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.mutti.interusp_android.Model.Torcida;
import com.example.mutti.interusp_android.R;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Mutti on 10/05/16.
 */
public class TorcidometroAdapter extends ArrayAdapter<Torcida> {

    ArrayList<Torcida> list;
    Context context;
    int max;

    public TorcidometroAdapter(Context context, ArrayList<Torcida> list, int max) {
        super(context, 0, list);
        this.context = context;
        this.list = list;
        this.max = max;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    //Logica pra retornar o layout
    @Override
    public int getItemViewType(int position) {
        int type = 0;
      switch (list.get(position).getFacul_id()){

          case "1":
              type=1;
              break;
          case "2":
              type=2;
              break;
          case "3":
              type=3;
              break;
          case "4":
              type=4;
              break;
          case "5":
              type=5;
              break;
          case "6":
              type=6;
              break;
          case "7":
              type=7;
              break;
          case "8":
              type=8;
              break;

      }
        return type;
    }


    //Precisa dar override no getViewTypeCount pq se nao ele nao retorna os layouts direito
    @Override
    public int getViewTypeCount() {
        return 8;
    }

    @Override
    public Torcida getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Torcida faculdade = getItem(position);
        int type = getItemViewType(position);

        if (convertView == null) {

            switch (type){

                case 1:
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_torcida_poli, null);
                    break;
                case 2:
                    LayoutInflater inflater1 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater1.inflate(R.layout.item_torcida_fea, null);
                    break;
                case 3:
                    LayoutInflater inflater2 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater2.inflate(R.layout.item_torcida_farma, null);
                    break;
                case 4:
                    LayoutInflater inflater3 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater3.inflate(R.layout.item_torcida_esalq, null);
                    break;
                case 5:
                    LayoutInflater inflater4 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater4.inflate(R.layout.item_torcida_riberao, null);
                    break;
                case 6:
                    LayoutInflater inflater5 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater5.inflate(R.layout.item_torcida_sanfran, null);
                    break;
                case 7:
                    LayoutInflater inflater6 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater6.inflate(R.layout.item_torcida_odonto, null);
                    break;
                case 8:
                    LayoutInflater inflater7 = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    convertView = inflater7.inflate(R.layout.item_torcida_pinheiros, null);
                    break;

            }

        }

        ArrayList facul_name = new ArrayList();
        facul_name.addAll(Arrays.asList(context.getResources().getStringArray(R.array.facul_torcida)));

        TextView torcida = (TextView) convertView.findViewById(R.id.facul_name);
        ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar_torcida);
        TextView torcedores = (TextView) convertView.findViewById(R.id.torcedores);

        torcedores.setText(faculdade.getUsers_count());

        torcida.setText(facul_name.get(Integer.parseInt(faculdade.getFacul_id())-1).toString());

        progressBar.setMax(max);
        progressBar.setProgress(Integer.parseInt(faculdade.getUsers_count()));
        progressBar.setScaleY(2f);

        return convertView;
    }

}
