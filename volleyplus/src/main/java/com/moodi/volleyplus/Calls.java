package com.moodi.volleyplus;

import android.content.Context;

import com.android.volley.NoConnectionError;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

/**
 * Created by moodi on 28/07/2017.
 */

public class Calls {


    public static void stringRequest(
            final Context context,
            int method,
            String url,
            final VolleyPlusResponseString reference) {


        if (NetworkUtils.isConnected(context)) {
            StringRequest mStringRequest =
                    new StringRequest(method, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            reference.onResponse(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            reference.onError(error.getMessage());

                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                                reference.onConnectionError();

                            }

                        }
                    });

            AppController.getInstance(context).addToRequestQueue(mStringRequest);
        } else {

            reference.onConnectionError();

        }


    }

    public void jsonObjectRequest(Context context
            , int method
            , String url
            , JSONObject jsonObject
            , final VolleyPlusResponseJSON reference) {


        if (NetworkUtils.isConnected(context)) {

            JsonObjectRequest mJsonObjectRequest =
                    new JsonObjectRequest(method, url, jsonObject, new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            reference.onResponse(response);

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            reference.onError(error.getMessage());

                            if (error instanceof TimeoutError || error instanceof NoConnectionError) {

                                reference.onConnectionError();

                            }

                        }
                    });
            AppController.getInstance(context).addToRequestQueue(mJsonObjectRequest);
        } else {
            reference.onConnectionError();
        }


    }

}
