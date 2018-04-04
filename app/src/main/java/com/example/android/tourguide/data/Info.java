package com.example.android.tourguide.data;

/**
 * Created by ithom on 26.03.2018.
 * Info Class that hold similar data
 */

public final class Info {

    private String title;
    private String details;
    private int imgId;

    public Info(String title, String details, int imgId) {

        this.title = title;
        this.details = details;
        this.imgId = imgId;
    }


    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
