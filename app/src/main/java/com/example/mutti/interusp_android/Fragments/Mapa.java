package com.example.mutti.interusp_android.Fragments;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mutti.interusp_android.DetalheInformacao;
import com.example.mutti.interusp_android.Manager.GetLocal;
import com.example.mutti.interusp_android.Model.ListaLocais;
import com.example.mutti.interusp_android.R;
import com.example.mutti.interusp_android.Utils.Constants;
import com.example.mutti.interusp_android.Utils.DataHolder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

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

    ArrayList<ListaLocais> locais;

    private BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            locais = DataHolder.getInstance().getLocaisSalvos();
            criarMarkers();
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        activity = getActivity();
        context = getContext();

        locais = DataHolder.getInstance().getLocaisSalvos();
        if(locais.size()==0) {
            GetLocal getLocal = new GetLocal(context);
            getLocal.getLocais();
        }

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

                    ListaLocais listaLocais = null;
                    for (ListaLocais l : locais) {
                        if (markerTitle.equals(l.getNome())) {
                            listaLocais = l;
                            break;
                        }
                    }

                    if (listaLocais != null) {
                        Intent intent = new Intent(getActivity(), DetalheInformacao.class);
                        intent.putExtra("listaLocais", listaLocais);
                        getActivity().startActivity(intent);
                    }

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

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(latitude, longitude)).zoom(14).build();
        map.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

        return rootview;
    }

    @Override
    public void onResume() {
        super.onResume();
        mMapView.onResume();
        activity.registerReceiver(receiver, new IntentFilter(Constants.kGetLocaisDone));
    }

    @Override
    public void onPause() {
        super.onPause();
        mMapView.onPause();
        activity.unregisterReceiver(receiver);
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

    public void criarMarkers () {
        //Criador de markers
        for (ListaLocais listaLocais : locais) {
            MarkerOptions marker = new MarkerOptions().position(
                    new LatLng(listaLocais.getCoordenadas()[1], listaLocais.getCoordenadas()[0]))
                    .title(listaLocais.getNome());

            switch (listaLocais.getTipo()) {
                case 1:
                    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.info_ginasios));
                    break;
                case 2:
                    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.info_tenda));
                    break;
                case 3:
                    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.info_baladas));
                    break;
                case 5:
                    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.info_alojamento));
                    break;
                case 6:
                    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.info_hospital));
                    break;
                case 7:
                    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.info_delegacia));
                    break;
                case 8:
                    marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.info_comidas));
                    break;
                default:
                    break;
            }

            map.addMarker(marker);
        }


    }

}