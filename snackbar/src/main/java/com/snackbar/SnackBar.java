package com.snackbar;

import android.app.Activity;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.alertutil.alert.Alert;


/**
 * Created by clickapps on 22/1/18.
 */

public class SnackBar extends Alert {

    private SnackBar() {
    }

    /**
     * @param context the context
     * @param resId   the res id
     * @return the snack builder
     */
    public static SnackBuilder with(@NonNull Activity context, @StringRes int resId) {
        return new SnackBuilder(context, resId);
    }

    /**
     * With snack builder.
     *
     * @param context the context
     * @param msg     the msg
     * @return the snack builder
     */
    public static SnackBuilder with(@NonNull Activity context, @NonNull String msg) {
        return new SnackBuilder(context, msg);
    }

    /**
     * @param context         the context
     * @param resId           the res id
     * @param backgroundColor the color for snackbar
     * @return the snack builder
     */
    public static SnackBuilder with(@NonNull Activity context, @StringRes int resId, @ColorRes int backgroundColor) {
        return new SnackBuilder(context, resId, backgroundColor);
    }

    /**
     * With snack builder.
     *
     * @param context         the context
     * @param msg             the msg
     * @param backgroundColor the color for snackbar
     * @return the snack builder
     */
    public static SnackBuilder with(@NonNull Activity context, @NonNull String msg, @ColorRes int backgroundColor) {
        return new SnackBuilder(context, msg, backgroundColor);
    }

}
