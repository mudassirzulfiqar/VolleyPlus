package com.moodi.volleyplus;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by moodi on 28/07/2017.
 */

public class RetryDialog extends Dialog {

    OnDialogCallback onDialogCallback;
    String retryMessage = "No internet connection !";
    String buttonText = "Retry";
    Context context;
    int buttonColor = R.color.default_loader;
    Button retryButton;
    TextView bodyMessageTextview;

    public RetryDialog(@NonNull Context context, String retryMessage, String retryButtonMessage, int retryButtonColor, OnDialogCallback retryButtonListener) {
        super(context);
        this.context = context;
        initialize();
        this.retryMessage = retryMessage;
        this.buttonColor = retryButtonColor;
        this.buttonText = (retryButtonMessage);
        this.onDialogCallback = retryButtonListener;
        buildDesign();
    }

    public void setButtonColor(int color) {
        this.buttonColor = color;
    }

    public void setButtonText(String buttonText) {
        this.buttonText = buttonText;
    }

    public void setRetryMessage(String retryMessage) {
        this.retryMessage = retryMessage;
    }


    void initialize() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog_internet_layout);

        retryButton = (Button) findViewById(R.id.retry_button);
        bodyMessageTextview = (TextView) findViewById(R.id.body_message);

        retryButton.setOnClickListener(new View.OnClickListener() {

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

   public interface OnDialogCallback {
        void onRetryClick();
    }

    private void buildDesign() {

        GradientDrawable buttonBG = new GradientDrawable();
        buttonBG.setShape(GradientDrawable.RECTANGLE);
        buttonBG.setColor(ContextCompat.getColor(context, buttonColor));

        retryButton.setBackground(buttonBG);
        retryButton.setText(buttonText);
        bodyMessageTextview.setText(retryMessage);


    }


}
