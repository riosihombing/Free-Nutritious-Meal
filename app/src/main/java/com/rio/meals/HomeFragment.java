/*
 *     Tanggal Pengerjaan : 6/8/2024
 *     Nim : 10121050
 *     Nama : Rio Christian Cesar Sihombing
 *     email :riosihombing047@gmail.com
 *     Copyright © 2024 Rio Sihombing. All rights reserved.
 */
package com.rio.meals;

import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class HomeFragment extends Fragment {

    private DatabaseReference mDatabase;
    private TextView menuTextView; // Tambahkan TextView untuk menampilkan menu

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

        // Inisialisasi Firebase Database
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Inisialisasi komponen UI
        menuTextView = view.findViewById(R.id.menuTextView); // Inisialisasi TextView untuk menu

        // Ambil data dari Firebase
        mDatabase.child("menu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                StringBuilder menuBuilder = new StringBuilder();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String menuItem = snapshot.getValue(String.class);
                    if (menuBuilder.length() > 0) {
                        menuBuilder.append(", "); // Menambahkan koma dan spasi antara item
                    }
                    menuBuilder.append(menuItem);
                }
                menuTextView.setText(menuBuilder.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Tangani kesalahan
                Log.w("HomeFragment", "loadMenu:onCancelled", databaseError.toException());
            }
        });

        return view;
    }
}