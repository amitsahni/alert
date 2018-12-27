package com.snackbar

import android.view.View

/**
 * Created by amit on 24/1/17.
 */

interface OnSnackBarActionListener {
    fun onSnackBarActionClicked(tag: Int, view: View)
}
