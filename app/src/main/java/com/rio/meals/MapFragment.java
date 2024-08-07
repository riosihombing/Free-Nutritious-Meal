/*
 *     Tanggal Pengerjaan : 6/8/2024
 *     Nim : 10121050
 *     Nama : Rio Christian Cesar Sihombing
 *     email :riosihombing047@gmail.com
 *     Copyright © 2024 Rio Sihombing. All rights reserved.
 */
package com.rio.meals;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapFragment extends Fragment {

    public MapFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        // Initialize the Google Map
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {
                // Definisikan lokasi-lokasi
                LatLng sdsRancakasumba = new LatLng(-6.89501, 107.61477);

                // Tambahkan marker untuk setiap lokasi
                googleMap.addMarker(new MarkerOptions().position(sdsRancakasumba).title("Toko You"));

                // Pindahkan kamera ke lokasi pertama atau titik tengah dari semua lokasi
                LatLng center = new LatLng(-6.884000, 107.619000); // Titik tengah dari semua lokasi
                googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(center, 12));

                // Enable zoom controls and scrolling gestures
                googleMap.getUiSettings().setZoomControlsEnabled(true);
                googleMap.getUiSettings().setScrollGesturesEnabled(true);
            }
        });

        return view;
    }
}
