package com.alertutil.alert;


import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.widget.TextView;


/**
 * The type Alert.
 */
public class Alert {
    private static volatile Alert sAlert;

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
