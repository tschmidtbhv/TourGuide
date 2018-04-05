package com.example.android.tourguide.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapter.InfoAdapter;
import com.example.android.tourguide.data.Info;
import com.example.android.tourguide.helper.Config;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends HelperFragment {

    private int lastItemPosition = 0;

    private TextView title;
    private TextView details;
    private ImageView infoImage;
    private InfoAdapter infoAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_info, container, false);
        return setUpViews(view);
    }

    private View setUpViews(View view) {

        title = view.findViewById(R.id.infodetailTitle);
        details = view.findViewById(R.id.infodetailtext);
        infoImage = view.findViewById(R.id.infoimage);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        if (getResources().getBoolean(R.bool.isTablet)) {
            layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        }

        recyclerView.setLayoutManager(layoutManager);
        infoAdapter = new InfoAdapter(getInfoList());
        recyclerView.setAdapter(infoAdapter);
        if(!(lastItemPosition > 0))updateInfos(infoAdapter.getInfoItem(0), lastItemPosition);
        return view;
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState != null){
            lastItemPosition = savedInstanceState.getInt(Config.LASTITEMPOSITION);
            updateInfos(infoAdapter.getInfoItem(lastItemPosition),lastItemPosition);
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(Config.LASTITEMPOSITION, lastItemPosition);
    }

    public void updateInfos(Info info, int position) {
        lastItemPosition = position;
        title.setText(info.getTitle());
        details.setText(info.getDetails());
        infoImage.setImageResource(info.getImgId());
    }
}
