package com.dialog;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

import com.alertutil.alert.Alert;

/**
 * Created by clickapps on 22/1/18.
 */

public class Dialog extends Alert {

    private Dialog() {
    }

    /**
     * *******************************************************************************************************************
     *
     * @param context    the context
     * @return the dialog builder
     */
    public static DialogBuilder with(@NonNull Context context) {
        return new DialogBuilder(context);
    }

}
