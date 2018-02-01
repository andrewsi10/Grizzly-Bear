package com.grizzlybear;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Andrew on 1/31/2018.
 */
public interface Routes {

    @GET("https://guidebook.com/service/v2/upcomingGuides/")
    Call<List<Guide>> parseAndDisplay();
}
