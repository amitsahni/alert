package com.progressView

import android.app.Dialog
import android.content.Context
import android.view.View
import android.view.Window


/**
 * This class used for the base class of all dialogs in the application.
 *
 * @author clickapps
 */
open class BaseDialog : Dialog, View.OnClickListener {

    /**
     * Instantiates a new Base dialog.
     *
     * @param context the context
     */
    constructor(context: Context) : super(context) {
        hideTitle()
    }

    /**
     * Instantiates a new Base dialog.
     *
     * @param context the context
     * @param theme   the theme
     */
    constructor(context: Context, theme: Int) : super(context, theme) {
        hideTitle()
    }

    override fun onClick(v: View) {

    }

    /**
     * hide the dialog title
     */
    private fun hideTitle() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
    }

}
