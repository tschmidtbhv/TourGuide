package com.example.android.tourguide.helper;

/**
 * Created by ithom on 26.03.2018.
 * Is used for Global App Config
 */

public interface Config {

    String MENUVARIANT = "MENUVARIANT";
    String FRAGMENTTAG = "FRAGMENTTAG";

    int MENUCOUNTRY = 0;
    int MENUCITY = 1;
    int MENURIVERANDLAKES = 2;
    int MENUATTRACTIONS = 3;
    int MENUPARKS = 4;

    int NUMBEROFARTICLES = 10;

    // Prefix
    String MENUPREFIXCITIES = "cities";
    String MENUPREFIXRIVERLAKES = "rl";
    String MENUPREFIXATTRACTIONS = "att";
    String MENUPREFIXPARKS = "park";

    // Resource Types
    String RESOURCESTRING = "string";
    String RESOURCEDRAWABLE = "drawable";

    String LASTITEMPOSITION = "LASTITEMPOSITION";
}
