package com.snackbar

import android.app.Activity
import android.support.annotation.ColorRes
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.widget.TextView

/**
 * Created by clickapps on 2/11/17.
 */

class SnackBuilder constructor(context: Activity) {

    private var param: SnackBarParam = SnackBarParam()
    private var snackbar: Snackbar? = null

    init {
        param.context = context
    }

    constructor(context: Activity, @StringRes resId: Int) : this(context) {
        context?.let {
            param.message = context.getString(resId)
        }
    }

    constructor(context: Activity, msg: String) : this(context) {
        param.message = msg
    }

    constructor(context: Activity, @StringRes resId: Int, @ColorRes backgroundColor: Int) : this(context) {
        param.message = context.getString(resId)
        param.actionBackgroundResId = backgroundColor
    }

    constructor(context: Activity, msg: String, @ColorRes backgroundColor: Int) : this(context) {
        param.message = msg
        param.actionBackgroundResId = backgroundColor
    }

    fun actionMessage(actionMessage: String): SnackBuilder {
        param.actionMessage = actionMessage
        return this
    }

    fun actionMessage(@StringRes resId: Int): SnackBuilder {
        param.context?.let {
            param.actionMessage = param.context!!.getString(resId)
        }
        return this
    }

    fun view(view: View): SnackBuilder {
        param.snackBarView = view
        param.snackBarView?.isFocusable = false
        return this
    }

    fun listener(l: OnSnackBarActionListener): SnackBuilder {
        param.onSnackBarActionListener = l
        return this
    }

    fun actionColor(@ColorRes resId: Int): SnackBuilder {
        param.actionColorResId = resId
        return this
    }

    fun textColor(@ColorRes resId: Int): SnackBuilder {
        param.textColor = resId
        return this
    }

    fun duration(duration: Int): SnackBuilder {
        param.snackBarDuration = duration
        return this
    }

    fun backgroundColor(@ColorRes color: Int): SnackBuilder {
        param.actionBackgroundResId = color
        return this
    }

    fun info(): SnackBuilder {
        param.actionBackgroundResId = SnackBarParam.blue
        return this
    }

    fun confirm(): SnackBuilder {
        param.actionBackgroundResId = SnackBarParam.green
        return this
    }

    fun warning(): SnackBuilder {
        param.actionBackgroundResId = SnackBarParam.orange
        return this
    }

    fun alert(): SnackBuilder {
        param.actionBackgroundResId = SnackBarParam.red
        return this
    }

    fun tag(tag: Int): SnackBuilder {
        param.alertTaskId = tag
        return this
    }

    fun actionMessageMaxLines(maxLines: Int): SnackBuilder {
        param.actionMessageMaxLine = maxLines
        return this
    }

    fun typeface(typeface: String): SnackBuilder {
        param.typeface = typeface
        return this
    }

    /**
     * Show.
     */
    fun show(): SnackBarParam {
        snackbar?.dismiss()
        if (param.context == null) {
            Log.e(javaClass.name, "Context can't be null")
            return param
        }
        var context = param.context!!
        if (param.snackBarView == null) {
            param.snackBarView = context.findViewById(android.R.id.content)
        }
        snackbar = Snackbar.make(param.snackBarView!!, "", param.snackBarDuration)

        // Checked for Message
        if (param.message.isNotEmpty()) {
            snackbar?.setText(param.message)
        } else {
            snackbar?.setText("")
        }

        // checked for ActionMessage
        if (param.actionMessage.isNotEmpty()) {
            snackbar!!.setAction(param.actionMessage, { v ->
                param.onSnackBarActionListener?.onSnackBarActionClicked(param.alertTaskId, v)
            })
        } else {
            snackbar?.setAction("", null)
        }
        // checked for actionMessagecolor
        if (param.actionColorResId != -1) {
            snackbar?.setActionTextColor(ContextCompat.getColor(context, param.actionColorResId))
        }
        val tv = snackbar?.view?.findViewById<View>(android.support.design.R.id.snackbar_text) as TextView
        val tva = snackbar?.view?.findViewById<View>(android.support.design.R.id.snackbar_action) as TextView
        if (param.actionMessageMaxLine != -1)
            tv.maxLines = param.actionMessageMaxLine
        if (param.textColor != -1) {
            tv.setTextColor(ContextCompat.getColorStateList(context, param.textColor))
        }
        if (param.actionBackgroundResId != -1)
            snackbar?.view?.setBackgroundColor(ContextCompat.getColor(context, param.actionBackgroundResId))
        //check typeface
        if (param.typeface.isNotEmpty()) {
            val typeface = param.typeface
            //set message typeface
            SnackBar.get().setTypeface(context, tv, typeface)
            //set action typeface
            SnackBar.get().setTypeface(context, tva, typeface)
        }
        snackbar?.show()
        return param
    }

}
