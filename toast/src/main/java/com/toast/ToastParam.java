package com.toast;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by amit on 24/1/17.
 */

public class ToastParam {

    /**
     * The Message.
     */
    String message = "";
    /**
     * The Context.
     */
    Context context;
    /**
     * The Message res id.
     */
    int messageResId = -1;

    /*Typeface for the specific alert*/
    String typeface;

    /**
     * The Duration.
     */
    int duration = Toast.LENGTH_SHORT;

}
