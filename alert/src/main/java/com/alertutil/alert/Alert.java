package com.alertutil.alert;


import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.widget.TextView;


/**
 * The type Alert.
 */
public class Alert {
    private static volatile Alert sAlert;

    private Alert() {
        // private constructor
    }

    /**
     * Get alert.
     *
     * @return the alert
     */
    public static Alert get() {
        if (sAlert == null) {
            synchronized (Alert.class) {
                if (sAlert == null) {
                    sAlert = new Alert();
                }
            }
        }
        return sAlert;
    }

    /**
     * *******************************************************************************************************************
     *
     * @param context the context
     * @return the toast builder
     */
    public static ToastParam.ToastBuilder with(@NonNull Context context) {
        return new ToastParam.ToastBuilder(context);
    }

    /**
     * With toast builder.
     *
     * @param context the context
     * @param resId   the res id
     * @return the toast builder
     */
    public static ToastParam.ToastBuilder with(@NonNull Context context, @StringRes int resId) {
        return new ToastParam.ToastBuilder(context, resId);
    }

    /**
     * *******************************************************************************************************************
     *
     * @param context    the context
     * @param dialogType the dialog type
     * @return the dialog builder
     */
    public static AlertParam.DialogBuilder with(@NonNull Context context, @NonNull AlertParam.DialogType dialogType) {
        return new AlertParam.DialogBuilder(context, dialogType, -1);
    }

    /**
     * *******************************************************************************************************************
     *
     * @param context    the context
     * @param dialogType the dialog type
     * @return the dialog builder
     */
    public static AlertParam.DialogBuilder with(@NonNull Context context, @NonNull AlertParam.DialogType dialogType, @StyleRes int style) {
        return new AlertParam.DialogBuilder(context, dialogType, style);
    }

    /**
     * *******************************************************************************************************************
     * SnackBuilder class for showing Material SnackBuilder on Screen. To use this need to compile Design support lib
     * ************************************************/

    /**
     * @param context the context
     * @param resId   the res id
     * @return the snack builder
     */
    public static SnackBarParam.SnackBuilder with(@NonNull Activity context, @StringRes int resId) {
        return new SnackBarParam.SnackBuilder(context, resId);
    }

    /**
     * With snack builder.
     *
     * @param context the context
     * @param msg     the msg
     * @return the snack builder
     */
    public static SnackBarParam.SnackBuilder with(@NonNull Activity context, @NonNull String msg) {
        return new SnackBarParam.SnackBuilder(context, msg);
    }

    /**
     * @param context         the context
     * @param resId           the res id
     * @param backgroundColor the color for snackbar
     * @return the snack builder
     */
    public static SnackBarParam.SnackBuilder with(@NonNull Activity context, @StringRes int resId, @ColorRes int backgroundColor) {
        return new SnackBarParam.SnackBuilder(context, resId, backgroundColor);
    }

    /**
     * With snack builder.
     *
     * @param context         the context
     * @param msg             the msg
     * @param backgroundColor the color for snackbar
     * @return the snack builder
     */
    public static SnackBarParam.SnackBuilder with(@NonNull Activity context, @NonNull String msg, @ColorRes int backgroundColor) {
        return new SnackBarParam.SnackBuilder(context, msg, backgroundColor);
    }

    /***************
     *Helper methods*
     * **************/

    /**
     * Functionality to set type face or font for the text mView
     *
     * @param context  Context
     * @param textView TextView on which the text need to be formatted
     * @param typeface string that must be defined in assets
     */
    public void setTypeface(@NonNull Context context, @NonNull TextView textView, @NonNull String typeface) {
        Typeface tf = Typeface.createFromAsset(context.getAssets(),
                typeface);
        textView.setTypeface(tf);
    }

}
