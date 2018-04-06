package com.example.android.tourguide.adapter;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.data.Info;

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
        if (info.getImgId() != -1) {
            new ImageAsyncTask(holder.image, info.getImgId()).execute(holder);
        }
    }

    public Info getInfoItem(int position) {
        return infoArrayList.get(position);
    }

    /**
     * Inner AsyncTask to load the images
     * without block system UI
     * Try to make feeling smoother
     */
    public class ImageAsyncTask extends AsyncTask<ViewHolder, Void, Bitmap> {

        private ImageView mImageView;
        private int mImgId;

        public ImageAsyncTask(ImageView imageView, int imgId) {
            mImageView = imageView;
            mImgId = imgId;
        }

        @Override
        protected Bitmap doInBackground(ViewHolder... holder) {

            Resources resources = holder[0].itemView.getResources();
            Bitmap bitmap = BitmapFactory.decodeResource(resources, mImgId);

            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
        }
    }
}
