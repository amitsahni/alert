package com.dialog

import android.content.Context
import android.support.annotation.StringRes

/**
 * Created by clickapps on 2/11/17.
 */

class DialogBuilder constructor(context: Context) {

    private val param: AlertParam = AlertParam()

    init {
        param.context = context
    }


    fun asSingleOption(positiveButton: String): Request.SingleOptionBuilder {
        param.positiveButton = positiveButton
        param.dialogType = AlertParam.DialogType.SINGLE_OPTION
        return Request.SingleOptionBuilder(param)
    }

    fun asSingleOption(@StringRes positiveButton: Int): Request.SingleOptionBuilder {
        param.context?.let {
            param.positiveButton = param.context!!.getString(positiveButton)
        }
        param.dialogType = AlertParam.DialogType.SINGLE_OPTION
        return Request.SingleOptionBuilder(param)
    }

    fun asDoubleOption(positiveButton: String,
                       negativeButton: String): Request.DoubleOptionBuilder {
        param.positiveButton = positiveButton
        param.negativeButton = negativeButton
        param.dialogType = AlertParam.DialogType.DOUBLE_OPTION
        return Request.DoubleOptionBuilder(param)
    }

    fun asDoubleOption(@StringRes positiveButton: Int,
                       @StringRes negativeButton: Int): Request.DoubleOptionBuilder {
        param.context?.let {
            param.positiveButton = param.context!!.getString(positiveButton)
            param.negativeButton = param.context!!.getString(negativeButton)
        }
        param.dialogType = AlertParam.DialogType.DOUBLE_OPTION
        return Request.DoubleOptionBuilder(param)
    }

    fun asList(vararg list: String): Request.ListOptionBuilder {
        param.list = arrayOf<String>(*list)
        param.dialogType = AlertParam.DialogType.DIALOG_LIST
        return Request.ListOptionBuilder(param)
    }
}
