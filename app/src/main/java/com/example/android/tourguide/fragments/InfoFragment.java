package com.example.android.tourguide.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.tourguide.R;
import com.example.android.tourguide.adapter.InfoAdapter;
import com.example.android.tourguide.data.Info;
import com.example.android.tourguide.helper.InfoData;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends HelperFragment {

    private RecyclerView recyclerView;
    private TextView details;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        details = view.findViewById(R.id.infodetailtext);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new InfoAdapter(InfoData.createCities()));

        return view;
    }


    public void updateInfos(Info info) {
        details.setText(info.getDetails());
    }

}
