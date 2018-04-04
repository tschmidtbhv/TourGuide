package com.example.android.tourguide.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapter.InfoAdapter;
import com.example.android.tourguide.data.Info;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends HelperFragment {

    private RecyclerView recyclerView;
    private TextView title;
    private TextView details;
    private ImageView infoImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        title = view.findViewById(R.id.infodetailTitle);
        details = view.findViewById(R.id.infodetailtext);
        infoImage = view.findViewById(R.id.infoimage);
        recyclerView = view.findViewById(R.id.recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        if (getResources().getBoolean(R.bool.isTablet)) {
            layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        }

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new InfoAdapter(getInfoList()));

        return view;
    }


    public void updateInfos(Info info) {
        title.setText(info.getTitle());
        details.setText(info.getDetails());
        infoImage.setImageResource(info.getImgId());
    }

}
