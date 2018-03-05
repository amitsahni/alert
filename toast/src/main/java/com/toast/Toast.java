package com.toast;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

import com.alertutil.alert.Alert;


/**
 * Created by clickapps on 22/1/18.
 */

public class Toast extends Alert {

    private Toast() {
    }

    /**
     * *******************************************************************************************************************
     *
     * @param context the context
     * @return the toast builder
     */
    public static ToastBuilder with(@NonNull Context context) {
        return new ToastBuilder(context);
    }

    /**
     * With toast builder.
     *
     * @param context the context
     * @param resId   the res id
     * @return the toast builder
     */
    public static ToastBuilder with(@NonNull Context context, @StringRes int resId) {
        return new ToastBuilder(context, resId);
    }

}
