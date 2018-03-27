package com.example.android.tourguide.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.tourguide.activitys.CountryInfoActivity;
import com.example.android.tourguide.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * A simple {@link Fragment} subclass.
 */
public class CountryFragment extends HelperFragment implements OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    private SupportMapFragment mapFragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_country, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        LatLng germany = new LatLng(51.165691, 10.451526);
        LatLng berlin = new LatLng(52.510494, 13.396764);
        googleMap.addMarker(new MarkerOptions().position(berlin).title("Berlin"));

        googleMap.setOnInfoWindowClickListener(this);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(germany, 5));
        googleMap.getUiSettings().setScrollGesturesEnabled(false);
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        Intent intent = new Intent(getActivity(), CountryInfoActivity.class);
        startActivity(intent);
    }
}
