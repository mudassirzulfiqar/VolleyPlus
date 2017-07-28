package com.moodi.volleyplus;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by moodi on 28/07/2017.
 */
public class AppController {


    private static AppController mInstance;
    private RequestQueue mRequestQueue;
    private static Context mContext;

    private AppController(Context context) {
        mContext = context;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized AppController getInstance(Context context) {

        if (mInstance == null) {
            mInstance = new AppController(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }


}
