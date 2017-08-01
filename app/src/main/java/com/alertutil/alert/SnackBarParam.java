package com.alertutil.alert;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by amit on 24/1/17.
 */

public class SnackBarParam {
    protected static final int red = android.R.color.holo_red_light;
    protected static final int green = android.R.color.holo_green_light;
    protected static final int blue = android.R.color.holo_blue_light;
    protected static final int orange = android.R.color.holo_orange_light;
    /**
     * The Message.
     */
    protected String message = "", actionMessage = "", typeface;
    /**
     * The Context.
     */
    protected Context context;

    protected Activity activityContext;
    /**
     * The Message res id.
     */
    protected int messageResId = -1, actionMessageResId = -1, actionColorResId = -1,
            snackBarDuration = Snackbar.LENGTH_LONG, alertTaskId, actionMessageMaxLine = -1,
            textColor = -1;

    /**
     * The Action background res id.
     */
    protected int actionBackgroundResId = blue;

    /**
     * The Snack bar mView.
     */
    protected View snackBarView;

    /**
     * The On snack bar action listener.
     */
    protected OnSnackBarActionListener onSnackBarActionListener;

}
