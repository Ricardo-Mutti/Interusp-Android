package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.teste;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Mutti on 30/04/16.
 */
public class Mapa extends Fragment  {

    Activity activity;
    Context context;

//    private SupportMapFragment mapFragment;
//    private GoogleApiClient googleApiClient;
    private GoogleMap map;
    MapView mMapView;
    String selectedMarker;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();

        View rootview =  inflater.inflate(R.layout.fragment_mapa, container, false);
        mMapView = (MapView) rootview.findViewById(R.id.map);
        mMapView.onCreate(savedInstanceState);

        mMapView.onResume();// needed to get the map to display immediately

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        map = mMapView.getMap();
        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                String markerTitle = marker.getTitle();

                if (selectedMarker == null || !selectedMarker.equals(markerTitle)) {

                    selectedMarker = markerTitle;

                } else {

                    Intent intent = new Intent(getActivity(), teste.class);
                    intent.putExtra("nome", markerTitle);
                    getActivity().startActivity(intent);

                }

                return false;
            }
        });
        map.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                selectedMarker = null;
            }
        });



        // latitude and longitude
        double latitude = -23.1072;
        double longitude = -48.9255;

        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(latitude, longitude)).title("Ginasio");

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));

        // adding marker
        map.addMarker(marker);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(14).build();
        map.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        criarPontos();

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mMapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mMapView.onLowMemory();
    }

    public void criarPontos() {
        double latitude = -23.1072;
        double longitude = -48.9255;


        // create marker
        MarkerOptions marker = new MarkerOptions().position(
                new LatLng(-23.1075, -48.9346)).title("Hospital");

        // Changing marker icon
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));

        // adding marker
        map.addMarker(marker);

        // create marker
        MarkerOptions marker2 = new MarkerOptions().position(
                new LatLng(-23.1100, -48.9257)).title("Alojamento Poli");

        // Changing marker icon
        marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

        // adding marker
        map.addMarker(marker2);
    }

    public void criarMarkers () {
        //Criador de markers



    }

}