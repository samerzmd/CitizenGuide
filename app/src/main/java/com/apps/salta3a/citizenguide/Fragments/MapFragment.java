package com.apps.salta3a.citizenguide.Fragments;


import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.apps.salta3a.citizenguide.R;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.overlay.Marker;
import com.mapbox.mapboxsdk.views.MapView;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment {
    public static String locLatArgs="locLat";
    public static String locLonArgs="locLon";
    public static MapFragment newInstaince(double locLat,double locLon){
        MapFragment myFragment = new MapFragment();

        Bundle args = new Bundle();
        args.putDouble(locLatArgs, locLat);
        args.putDouble(locLonArgs, locLon);
        myFragment.setArguments(args);

        return myFragment;
    }

    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        double Lat= getArguments().getDouble(locLatArgs);
        double Lon= getArguments().getDouble(locLonArgs);
        View view= inflater.inflate(R.layout.fragment_map, container, false);
        MapView mapview= (MapView) view.findViewById(R.id.mapview);
        mapview.setCenter(new LatLng(Lat,Lon));
        mapview.addMarker(new Marker("ss", "ww", new LatLng(Lat, Lon)));
        mapview.setZoom(18);
        return view;
    }


}
