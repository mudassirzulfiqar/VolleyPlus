package com.moodi.volleyplusmain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.moodi.volleyplus.Calls;
import com.moodi.volleyplus.VolleyPlusResponseString;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Calls.stringRequest(this, Request.Method.PUT, "", new VolleyPlusResponseString() {
            @Override
            public void onResponse(String response) {

            }

            @Override
            public void onError(String message) {

            }

            @Override
            public void onConnectionError() {

            }
        });

    }
}
