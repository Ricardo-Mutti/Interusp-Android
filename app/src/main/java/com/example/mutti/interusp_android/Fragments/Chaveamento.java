package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.example.mutti.interusp_android.R;

/**
 * Created by Mutti on 30/04/16.
 */
public class Chaveamento extends Fragment {

    Activity activity;
    Context context;

    ImageView chave_1, chave_2,chave_3, chave_4, chave_5, chave_6, chave_7, chave_8,
            chave_9, chave_10, chave_11, chave_12, chave_13, chave_14, chave_15;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();

        chave_1.findViewById(R.id.chave_1);
        chave_2.findViewById(R.id.chave_2);
        chave_3.findViewById(R.id.chave_3);
        chave_4.findViewById(R.id.chave_4);
        chave_5.findViewById(R.id.chave_5);
        chave_6.findViewById(R.id.chave_6);
        chave_7.findViewById(R.id.chave_7);
        chave_8.findViewById(R.id.chave_8);
        chave_9.findViewById(R.id.chave_9);
        chave_10.findViewById(R.id.chave_10);
        chave_11.findViewById(R.id.chave_11);
        chave_12.findViewById(R.id.chave_12);
        chave_13.findViewById(R.id.chave_13);
        chave_14.findViewById(R.id.chave_14);
        chave_15.findViewById(R.id.chave_15);

        chave_1.setImageResource(R.drawable.icon_sanfran);
        chave_2.setImageResource(R.drawable.icon_sanfran);
        chave_3.setImageResource(R.drawable.icon_sanfran);
        chave_4.setImageResource(R.drawable.icon_sanfran);
        chave_5.setImageResource(R.drawable.icon_sanfran);
        chave_6.setImageResource(R.drawable.icon_sanfran);
        chave_7.setImageResource(R.drawable.icon_sanfran);
        chave_8.setImageResource(R.drawable.icon_sanfran);
        chave_9.setImageResource(R.drawable.icon_sanfran);
        chave_10.setImageResource(R.drawable.icon_sanfran);
        chave_11.setImageResource(R.drawable.icon_sanfran);
        chave_12.setImageResource(R.drawable.icon_sanfran);
        chave_13.setImageResource(R.drawable.icon_sanfran);
        chave_14.setImageResource(R.drawable.icon_sanfran);
        chave_15.setImageResource(R.drawable.icon_sanfran);


















        View rootview =  inflater.inflate(R.layout.fragment_chaveamento, container, false);

        return rootview;
    }

}