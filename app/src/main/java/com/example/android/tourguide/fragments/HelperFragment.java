package com.example.android.tourguide.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.android.tourguide.data.Info;
import com.example.android.tourguide.helper.Config;
import com.example.android.tourguide.helper.InfoData;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HelperFragment extends Fragment {

    private List<Info> infoList;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Bundle bundle = getArguments();
        if (bundle != null) {

            int menuId = getArguments().getInt(Config.MENUVARIANT);
            Log.v(HelperFragment.class.getSimpleName(), "onCreate " + menuId);
            int menuTitleResourceId = InfoData.getTitleId(menuId);
            ((AppCompatActivity) getActivity()).setTitle(menuTitleResourceId);
            if (menuId != Config.MENUCOUNTRY) {
                InfoData infoData = new InfoData(getActivity(), menuId);
                infoList = infoData.getInfoList();
            }
        }
    }

    public List<Info> getInfoList() {
        return infoList;
    }
}
