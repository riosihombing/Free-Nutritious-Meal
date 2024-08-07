/*
 *     Tanggal Pengerjaan : 6/8/2024
 *     Nim : 10121050
 *     Nama : Rio Christian Cesar Sihombing
 *     email :riosihombing047@gmail.com
 *     Copyright © 2024 Rio Sihombing. All rights reserved.
 */
package com.rio.meals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder> {
    private List<GridItem> mItems;

    public GridAdapter() {
        super();
        mItems = new ArrayList<GridItem>();
        GridItem nama = new GridItem();
        nama.setThumbnail(R.drawable.g1);
        mItems.add(nama);

        nama = new GridItem();
        nama.setThumbnail(R.drawable.g2);
        mItems.add(nama);

        nama = new GridItem();
        nama.setThumbnail(R.drawable.g3);
        mItems.add(nama);

        nama = new GridItem();
        nama.setThumbnail(R.drawable.g4);
        mItems.add(nama);

        nama = new GridItem();
        nama.setThumbnail(R.drawable.g5);
        mItems.add(nama);

        nama = new GridItem();
        nama.setThumbnail(R.drawable.g6);
        mItems.add(nama);

        nama = new GridItem();
        nama.setThumbnail(R.drawable.g7);
        mItems.add(nama);

        nama = new GridItem();
        nama.setThumbnail(R.drawable.g8);
        mItems.add(nama);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.grid_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        GridItem nature = mItems.get(i);
        viewHolder.imgThumbnail.setImageResource(nature.getThumbnail());
    }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder  {


        public ImageView imgThumbnail;

        public ViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = (ImageView)itemView.findViewById(R.id.img_thumbnail);

        }
    }
}
