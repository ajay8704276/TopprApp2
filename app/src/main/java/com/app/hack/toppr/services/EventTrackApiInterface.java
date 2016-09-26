package com.app.hack.toppr.services;

import com.app.hack.toppr.model.Websites;
import com.app.hack.toppr.ultis.Constant;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ajay Kumar on 9/24/2016.
 */

public interface EventTrackApiInterface {

    /**
     *
     * @param type -
     * @param query
     * @return
     */

    @GET("/api/toppr_events")
    Call<Websites> getEventTrackDetails(@Query(Constant.DEFAULT_PARAMETER_TYPE) String type ,
                                        @Query(Constant.DEFAULT_PARAMETER_QUERY) String query);
}
