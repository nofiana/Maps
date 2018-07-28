package com.example.android.peta.Network;


import com.example.android.peta.model.ResponseWayPoint;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by FUADMASKA on 6/16/2017.
 */

public interface ApiService {

        @GET("api/directions/json")
        Call<ResponseWayPoint> request_route(
                @Query("origin") String origin,
                @Query("destination") String tujuan



        );




}
