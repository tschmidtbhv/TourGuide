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
import com.example.android.tourguide.helper.Config;
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

    /**
     * onMapReady
     * called when map is ready
     * used to set intial
     * @param googleMap Map
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        //Create Latitude Longitude Object
        LatLng germany = new LatLng(Config.GERMANCENTERLAT, Config.GERMANCENTERLNG);

        //Add the marker to the map to center of Germany with title
        googleMap.addMarker(new MarkerOptions().position(germany).title(getString(R.string.title_germany_card)));

        //Set onClicklistener and set its zoomlv
        googleMap.setOnInfoWindowClickListener(this);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(germany, Config.MAPZOOMLV));
        googleMap.getUiSettings().setScrollGesturesEnabled(false);
    }

    /**
     * onInfoWindowClick
     * Called when the user click the marker InfoWindow
     * @param marker mapMarker
     */
    @Override
    public void onInfoWindowClick(Marker marker) {

        //Open CountryInfo Activity
        Intent intent = new Intent(getActivity(), CountryInfoActivity.class);
        startActivity(intent);
    }
}
