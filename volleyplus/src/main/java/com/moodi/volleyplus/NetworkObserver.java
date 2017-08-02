package com.moodi.volleyplus;

/**
 * Created by moodi on 28/07/2017.
 */


public class NetworkObserver {

    private INetworkObserver mINetworkObserver;

    public INetworkObserver getNetworkObserver() {
        return mINetworkObserver;
    }

    public void setNetworkObserver(INetworkObserver mINetworkObserver) {
        this.mINetworkObserver = mINetworkObserver;
    }

    private static final NetworkObserver instance = new NetworkObserver();

    public static NetworkObserver getInstance() {
        return instance;
    }


    public NetworkObserver() {
    }

    public interface INetworkObserver {

        void isAvalibale(boolean status);

    }


}


