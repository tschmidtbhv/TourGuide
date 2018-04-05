package com.example.android.tourguide.helper;

import android.content.Context;
import android.util.Log;

import com.example.android.tourguide.R;
import com.example.android.tourguide.activitys.MainActivity;
import com.example.android.tourguide.data.Info;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ithom on 26.03.2018.
 * Class is used to provide
 * city, lakes etc data
 */

public final class InfoData {

    Context mContext;
    List<Info> mInfoList;


    public InfoData(Context context, int menuId){
        mContext = context;
        createInfosForMenuId(menuId);
    }

    /**
     * Get the Title Id
     *
     * @param menuId
     * @return titleId
     */
    public static int getTitleId(int menuId) {

        int titleId;

        switch (menuId) {

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
            case Config.MENUPARKS:
                titleId = R.string.parks;
                break;
            default:
                titleId = R.string.app_name;
                break;
        }

        return titleId;
    }

    public List<Info> getInfoList() {
        return mInfoList;
    }

    /**
     * Get the infos
     *
     * @param menuId
     * @return titleId
     */
    private void createInfosForMenuId(int menuId) {

        if(mInfoList == null)mInfoList = new ArrayList<>();

        switch (menuId) {

            case Config.MENUCITY:
                mInfoList = getInfoDataForPrefix(Config.MENUPREFIXCITIES);
                break;
            case Config.MENURIVERANDLAKES:
                mInfoList = getInfoDataForPrefix(Config.MENUPREFIXRIVERLAKES);
                break;
            case Config.MENUATTRACTIONS:
                mInfoList = getInfoDataForPrefix(Config.MENUPREFIXATTRACTIONS);
                break;
            case Config.MENUPARKS:
                mInfoList = getInfoDataForPrefix(Config.MENUPREFIXPARKS);
                break;
            default:
                mInfoList = getInfoDataForPrefix(Config.MENUPREFIXCITIES);
                break;
        }


    }

    private String getFullResourceStringId(String prefix, int itemNumber, int itemField) {
        String path = mContext.getString(R.string.fullpath, prefix, itemNumber, itemField);
        Log.v(InfoData.class.getSimpleName(), "path " + path);
        return path;
    }

    /**
     * Get Info Objects for given prefix
     *
     * @param prefix for selected Menu
     * @return List
     */
    private List<Info> getInfoDataForPrefix(String prefix) {
        List<Info> infoList = new ArrayList<>();
        for (int i = 0; i < Config.NUMBEROFARTICLES; i++) {

            String title = getStringResourceByName(getFullResourceStringId(prefix,(i +1),1));
            String details = getStringResourceByName(getFullResourceStringId(prefix,(i +1),2));
            String image = getStringResourceByName(getFullResourceStringId(prefix,(i +1),3));

            int imageId = getResourceId(image, Config.RESOURCEDRAWABLE);

            Info info = new Info(title, details, imageId);
            infoList.add(info);
        }
        return infoList;
    }

    /**
     * Get String from Resource by name insteed of "int" id
     *
     * @param resourceString The resource as String
     * @return resource String
     */
    private String getStringResourceByName(String resourceString) {
        int resId = getResourceId(resourceString, Config.RESOURCESTRING);
        return mContext.getString(resId);
    }

    /**
     * Get the ResourceId for a String
     * @param resourceString The resource as String
     * @param type resource type
     * @return resourceId int
     */
    private int getResourceId(String resourceString, String type){
        int resId = mContext.getResources().getIdentifier(resourceString, type, MainActivity.PACKAGE_NAME);
        return resId;
    }

}
