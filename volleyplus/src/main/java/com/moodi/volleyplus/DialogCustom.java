package com.moodi.volleyplus;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Window;

/**
 * Created by moodi on 28/07/2017.
 */

public class DialogCustom extends Dialog {


    public DialogCustom(@NonNull Context context) {
        super(context);
        init(context);
    }

    public DialogCustom(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        init(context);
    }

    protected DialogCustom(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init(context);
    }

    void init(Context context) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.dialog_layout);
        show();
    }

}
