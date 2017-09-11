package com.epicodus.annatimofeyeva.myrestaurants;

import android.util.Log;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Guest on 9/11/17.
 */

public class YelpService {
    public static final String TAG = YelpService.class.getSimpleName();

    public static void findRestaurants(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient();

        String authString = Constants.YELP_ACCESS_TYPE + Constants.YELP_ACCESS_TOKEN;

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.YELP_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YELP_LOCATION_QUERY_PARAMETER, location);
        String url = urlBuilder.build().toString();

        Log.v(TAG, url);

        Request request = new Request.Builder()
                .header("Authorization", authString)
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }
}
