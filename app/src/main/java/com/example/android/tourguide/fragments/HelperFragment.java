package com.example.android.tourguide.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.android.tourguide.helper.Config;
import com.example.android.tourguide.helper.InfoData;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelperFragment extends Fragment {


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle bundle = getArguments();
        if (bundle != null) {

            int titleId = InfoData.getTitleId(bundle.getInt(Config.MENUVARIANT));
            ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(titleId);
        }
    }

}
