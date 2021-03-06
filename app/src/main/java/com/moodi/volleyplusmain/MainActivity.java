package com.moodi.volleyplusmain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.moodi.volleyplus.NetworkObserver;
import com.moodi.volleyplus.RetryDialog;
import com.moodi.volleyplus.RetryDialogBuilder;

public class MainActivity extends AppCompatActivity implements NetworkObserver.INetworkObserver {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new RetryDialogBuilder(this)
                .setRetryMessage("No Internet Available!!")
                .setRetryButtonColor(R.color.colorAccent)
                .setRetryButtonMessage("Retry")
                .addRetryButtonListener(new RetryDialog.OnDialogCallback() {
                    @Override
                    public void onRetryClick() {
                        Toast.makeText(MainActivity.this, "yess", Toast.LENGTH_SHORT).show();
                    }
                })
                .buildDialog()
                .show();

    }

    @Override
    public void isAvailable(boolean status) {
        Toast.makeText(this, "" + status, Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onResume() {
        super.onResume();

        NetworkObserver.getInstance().setNetworkObserver(this);

    }
}
