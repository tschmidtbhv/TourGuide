package com.example.android.tourguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.data.Info;

import java.util.ArrayList;

/**
 * Created by ithom on 26.03.2018.
 */

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    public interface OnInfoItemSelectedListener {
        public void onInfoSelected(Info info);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.infoimage);
        }
    }

    private ArrayList<Info> infoArrayList;


    public InfoAdapter(ArrayList<Info> infoArrayLis) {
        this.infoArrayList = infoArrayLis;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.infolist_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Info info = infoArrayList.get(viewHolder.getAdapterPosition());
                ((OnInfoItemSelectedListener) parent.getContext()).onInfoSelected(info);
            }
        });

        return viewHolder;
    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.image.setImageResource();
    }
}
