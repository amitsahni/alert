package com.dialog;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import com.alertutil.alert.Alert;

/**
 * Created by clickapps on 22/1/18.
 */

public class Dialog extends Alert {

    /**
     * *******************************************************************************************************************
     *
     * @param context    the context
     * @param dialogType the dialog type
     * @return the dialog builder
     */
    public static DialogBuilder with(@NonNull Context context, @NonNull AlertParam.DialogType dialogType) {
        return new DialogBuilder(context, dialogType, -1);
    }

    /**
     * *******************************************************************************************************************
     *
     * @param context    the context
     * @param dialogType the dialog type
     * @return the dialog builder
     */
    public static DialogBuilder with(@NonNull Context context, @NonNull AlertParam.DialogType dialogType, @StyleRes int style) {
        return new DialogBuilder(context, dialogType, style);
    }
}
