package com.moodi.volleyplus;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by moodi on 28/07/2017.
 */

public class ConnectifyReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent arg1) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();

        if (NetworkObserver.getInstance().getNetworkObserver() != null) {
            NetworkObserver.getInstance().getNetworkObserver().isAvalibale(isConnected);
        }

    }


}
