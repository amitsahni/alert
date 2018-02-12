package com.snackbar

import android.app.Activity
import android.support.design.widget.Snackbar
import android.view.View

/**
 * Created by amit on 24/1/17.
 */

class SnackBarParam {
    /**
     * The Message.
     */
    internal var message: String = ""
    internal var actionMessage: String = ""
    internal var typeface: String = ""
    /**
     * The Context.
     */
    internal var context: Activity? = null

    /**
     * The Message res id.
     */
    internal var actionColorResId = -1
    internal var snackBarDuration = Snackbar.LENGTH_LONG
    internal var alertTaskId: Int = 0
    internal var actionMessageMaxLine = -1
    internal var textColor = -1

    /**
     * The Action background res id.
     */
    internal var actionBackgroundResId = blue

    /**
     * The Snack bar mView.
     */
    internal var snackBarView: View? = null

    /**
     * The On snack bar action listener.
     */
    internal var onSnackBarActionListener: OnSnackBarActionListener? = null

    companion object {
        val red = android.R.color.holo_red_light
        val green = android.R.color.holo_green_light
        val blue = android.R.color.holo_blue_light
        val orange = android.R.color.holo_orange_light
    }

}
