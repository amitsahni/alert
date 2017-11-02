package com.alertutil.alert;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alertutil.R;

/**
 * Created by amit on 24/1/17.
 */

public class SnackBarParam {
    public static final int red = android.R.color.holo_red_light;
    public static final int green = android.R.color.holo_green_light;
    public static final int blue = android.R.color.holo_blue_light;
    public static final int orange = android.R.color.holo_orange_light;
    /**
     * The Message.
     */
     String message = "", actionMessage = "", typeface;
    /**
     * The Context.
     */
     Context context;

     Activity activityContext;
    /**
     * The Message res id.
     */
     int messageResId = -1, actionMessageResId = -1, actionColorResId = -1,
            snackBarDuration = Snackbar.LENGTH_LONG, alertTaskId, actionMessageMaxLine = -1,
            textColor = -1;

    /**
     * The Action background res id.
     */
     int actionBackgroundResId = blue;

    /**
     * The Snack bar mView.
     */
     View snackBarView;

    /**
     * The On snack bar action listener.
     */
     OnSnackBarActionListener onSnackBarActionListener;
        
}
