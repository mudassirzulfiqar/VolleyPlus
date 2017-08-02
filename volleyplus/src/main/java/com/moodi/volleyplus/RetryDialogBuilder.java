package com.moodi.volleyplus;

import android.content.Context;

public class RetryDialogBuilder {
    private Context context;
    private String retryMessage;
    private String retryButtonMessage;
    private int retryButtonColor;
    private RetryDialog.OnDialogCallback onDialogCallback;


    public RetryDialogBuilder(Context context) {
        this.context = context;
    }

    public RetryDialogBuilder setRetryMessage(String retryMessage) {
        this.retryMessage = retryMessage;
        return this;
    }

    public RetryDialogBuilder setRetryButtonMessage(String retryButtonMessage) {
        this.retryButtonMessage = retryButtonMessage;
        return this;
    }

    public RetryDialogBuilder setRetryButtonColor(int retryButtonColor) {
        this.retryButtonColor = retryButtonColor;
        return this;
    }

    public RetryDialogBuilder addRetryButtonListener(RetryDialog.OnDialogCallback retryButtonListener) {
        this.onDialogCallback = retryButtonListener;
        return this;
    }

    public RetryDialog buildDialog() {
        return new RetryDialog(context, retryMessage, retryButtonMessage, retryButtonColor, onDialogCallback);
    }
}