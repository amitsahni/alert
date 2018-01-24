package com.snackbar;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;

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
    Activity context;

    /**
     * The Message res id.
     */
    int actionColorResId = -1,
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
