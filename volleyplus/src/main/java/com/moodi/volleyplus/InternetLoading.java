package com.moodi.volleyplus;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.widget.ProgressBar;

import com.github.ybq.android.spinkit.style.RotatingPlane;

/**
 * Created by moodi on 28/07/2017.
 */

public class InternetLoading extends ProgressBar {

    int color = R.color.default_loader;

    public InternetLoading(Context context) {
        super(context);
        init(context);

    }

    public InternetLoading(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InternetLoading(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void setColor(int color) {
        this.color = color;
    }

    void init(Context context) {
        RotatingPlane threeBounce = new RotatingPlane();
        threeBounce.setColor(ContextCompat.getColor(context, color));
        setIndeterminateDrawable(threeBounce);
    }
}
