package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mutti.interusp_android.R;

/**
 * Created by Mutti on 30/04/16.
 */
public class Informacoes extends Fragment {

    Activity activity;
    Context context;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();


        View rootview =  inflater.inflate(R.layout.fragment_informacoes, container, false);

        return rootview;
    }

}
