package com.moodi.volleyplus;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;

/**
 * Created by moodi on 28/07/2017.
 */

public class RetryDialog extends Dialog {

    OnDialogCallback onDialogCallback;
    int retryMessage = R.string.retryMessage;


    public RetryDialog(@NonNull Context context) {
        super(context);
        build(context);
    }


    void build(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog_internet_layout);

        this.findViewById(R.id.retry_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (onDialogCallback != null) {
                    onDialogCallback.onRetryClick();
                    cancel();
                }
            }
        });


        setCancelable(false);


    }

    public void addOnRetryClick(OnDialogCallback onDialogCallback) {
        this.onDialogCallback = onDialogCallback;
    }

    interface OnDialogCallback {
        void onRetryClick();
    }
}
