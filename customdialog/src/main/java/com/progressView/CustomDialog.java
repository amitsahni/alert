package com.progressView;

import android.content.Context;
import android.support.annotation.NonNull;

import com.alertutil.alert.Alert;

/**
 * Created by amit on 4/2/18.
 */

public class CustomDialog extends Alert {

    private CustomDialog() {
    }

    /**
     * *******************************************************************************************************************
     *
     * @param context    the context
     * @return the dialog builder
     */
    public static Builder with(@NonNull Context context) {
        return new Builder(context);
    }
}
