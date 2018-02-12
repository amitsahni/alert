package com.dialog

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.IdRes


/**
 * The type Alert param.
 */
class AlertParam {

    internal var message = ""
    internal var context: Context? = null
    internal var title = ""
    internal var alertTaskId = -1
    internal var dialogType = DialogType.SINGLE_OPTION
    internal var listener: OnDialogClickListener? = null
    internal var onDialogListClickListener: OnDialogListClickListener? = null
    @IdRes
    internal var style = -1
    internal var drawable: Drawable? = null
    internal var positiveButton = ""
    internal var negativeButton = ""

    internal var positiveBtnColor = -1
    internal var negativeBtnColor = -1
    internal var bundle = Bundle()
    /**
     * The Is cancelable.
     */
    internal var isCancelable = true
    internal var list : Array<String> = arrayOf()

    internal var typeface = ""

    /**
     * The enum Dialog type.
     */
    enum class DialogType {
        /**
         * Single option dialog type.
         */
        SINGLE_OPTION,
        /**
         * Double option dialog type.
         */
        DOUBLE_OPTION,
        /**
         * Dialog list dialog type.
         */
        DIALOG_LIST
    }
}
