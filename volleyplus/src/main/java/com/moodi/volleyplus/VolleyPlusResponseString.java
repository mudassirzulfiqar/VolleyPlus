package com.moodi.volleyplus;

/**
 * Created by moodi on 28/07/2017.
 */

public interface VolleyPlusResponseString {

    void onResponse(String response);

    void onError(String message);

    void onConnectionError();
}
