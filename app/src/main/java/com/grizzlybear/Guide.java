package com.grizzlybear;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrew on 1/31/2018.
 */

public class Guide {

    String startDate, objType, endDate, name, url, icon;
    boolean loginRequired;
    Object venue;

    @Override
    public String toString() {
        return name + " " + objType + " " + startDate + " " + endDate + " " + url + " " + icon;
    }
}
