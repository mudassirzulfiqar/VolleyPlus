package com.moodi.volleyplus;

import org.json.JSONObject;

/**
 * Created by moodi on 28/07/2017.
 */

 public interface VolleyPlusResponseJSON {
    void onResponse(JSONObject response);

    void onConnectionError();

    void onError(String message);
}
