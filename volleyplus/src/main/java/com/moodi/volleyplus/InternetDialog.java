package com.moodi.volleyplus;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.View;
import android.view.Window;

/**
 * Created by moodi on 28/07/2017.
 */

public class InternetDialog extends Dialog {
    public InternetDialog(@NonNull Context context) {
        super(context);
        init(context);
    }

    public InternetDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected InternetDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog_internet_layout);

        this.findViewById(R.id.retry_button).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cancel();
            }
        });

        setCancelable(false);


    }
}
