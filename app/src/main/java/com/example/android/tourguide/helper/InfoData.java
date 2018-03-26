package com.example.android.tourguide.helper;

import com.example.android.tourguide.R;
import com.example.android.tourguide.data.Info;

import java.util.ArrayList;

/**
 * Created by ithom on 26.03.2018.
 * Class is used to provide
 * city, lakes etc data
 */

public final class InfoData {


    /**
     * Get the Title Id
     * @param menuId
     * @return titleId
     */
    public static int getTitleId(int menuId) {

        int titleId;

        switch (menuId){

            case Config.MENUCOUNTRY:
                titleId = R.string.country;
                break;
            case Config.MENUCITY:
                titleId = R.string.cities;
                break;
            case Config.MENURIVERANDLAKES:
                titleId = R.string.river_and_lake;
                break;
            case Config.MENUATTRACTIONS:
                titleId = R.string.attractions;
                break;
            default:
                titleId = R.string.app_name;
                break;
        }

        return titleId;
    }

    /**
     * create the cities ArrayList
     * @return ArrayList with Info Object (Cities)
     */
    public static ArrayList<Info> createCities() {

        ArrayList<Info> cities = new ArrayList<>();
        for(int i = 0; i< 20; i++){
            Info info = new Info();
            info.setTitle("Titel " + (i +1));
            info.setDetails("Details");
            if((i % 2) == 0)info.setDetails("DETAILS");
            //TODO add city informations
            cities.add(info);
        }
        return cities;
    }
}
