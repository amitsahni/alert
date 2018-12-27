package com.toast

import android.content.Context
import android.widget.Toast

/**
 * Created by amit on 24/1/17.
 */

class ToastParam {

    /**
     * The Message.
     */
    internal var message = ""
    /**
     * The Context.
     */
    internal var context: Context? = null
    /**
     * The Message res id.
     */
    internal var messageResId = -1

    /*Typeface for the specific alert*/
    internal var typeface: String? = null

    /**
     * The Duration.
     */
    internal var duration = Toast.LENGTH_SHORT

}
