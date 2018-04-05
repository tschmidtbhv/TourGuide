package com.example.android.tourguide.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.data.Info;
import com.example.android.tourguide.helper.InfoData;

import java.util.List;

/**
 * Created by ithom on 26.03.2018.
 */

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.ViewHolder> {

    public interface OnInfoItemSelectedListener {
        void onInfoSelected(Info info, int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView detail;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.imagetitle);
            detail = itemView.findViewById(R.id.infodetailtext);
            image = itemView.findViewById(R.id.infoimage);
        }
    }

    private List<Info> infoArrayList;


    public InfoAdapter(List<Info> infoArrayLis) {
        this.infoArrayList = infoArrayLis;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.infolist_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Info info = infoArrayList.get(position);
                ((OnInfoItemSelectedListener) parent.getContext()).onInfoSelected(info, position);
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

        Info info = infoArrayList.get(position);
        holder.title.setText(info.getTitle());
        Log.v(InfoAdapter.class.getSimpleName(), "onbind: " + info.getImgId());
        if(info.getImgId() != -1){
            holder.image.setImageResource(info.getImgId());
        }
    }

    public Info getInfoItem(int position){
        return infoArrayList.get(position);
    }
}
