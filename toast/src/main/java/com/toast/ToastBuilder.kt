package com.toast

import android.content.Context
import android.support.annotation.StringRes
import android.text.TextUtils
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

/**
 * Created by clickapps on 2/11/17.
 */

class ToastBuilder constructor(context: Context) {

    private var toastParam: ToastParam = ToastParam()
    private var mToast: Toast? = null

    init {
        toastParam.context = context
    }

    constructor(context: Context, @StringRes resId: Int) : this(context) {
        toastParam = ToastParam()
        toastParam.messageResId = resId
    }

    fun message(message: String): ToastBuilder {
        toastParam.message = message
        return this
    }

    fun message(resId: Int): ToastBuilder {
        toastParam.messageResId = resId
        return this
    }

    fun duration(duration: Int): ToastBuilder {
        toastParam.duration = duration
        return this
    }

    fun typeface(typeface: String): ToastBuilder {
        toastParam.typeface = typeface
        return this
    }

    fun show(): ToastParam {
        if (null != mToast) {
            mToast?.cancel()
        }
        if (toastParam.messageResId != -1) {
            mToast = Toast.makeText(toastParam.context?.applicationContext, toastParam.messageResId, toastParam.duration)
        } else {
            mToast = Toast.makeText(toastParam.context?.applicationContext, toastParam.message, toastParam.duration)
        }

        try {
            //find text mView
            val textView = (mToast?.view as LinearLayout).getChildAt(0) as TextView
            //check typeface
            if (!TextUtils.isEmpty(toastParam.typeface)) {
                com.toast.Toast.get().setTypeface(toastParam.context!!, textView, toastParam.typeface!!)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        mToast?.show()
        return toastParam
    }
}
