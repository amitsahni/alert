package com.dialog

import android.content.DialogInterface

/**
 * This interface is used as a call back for the dialogs
 */
interface OnDialogClickListener {

    enum class Button {
        POSITIVE,
        NEGATIVE,
        NEUTRAL
    }

    fun onClick(tag: Int, dialog: DialogInterface, pos: Int, button: Button)

}
