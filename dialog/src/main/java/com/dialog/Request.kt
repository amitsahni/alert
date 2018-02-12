package com.dialog

import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.support.annotation.ColorRes
import android.support.annotation.DrawableRes
import android.support.annotation.StringRes
import android.support.annotation.StyleRes
import android.support.v4.content.ContextCompat
import android.support.v7.app.AlertDialog
import android.text.TextUtils
import android.view.View
import android.widget.TextView

import com.alertutil.alert.Alert

@Suppress("UNCHECKED_CAST")
/**
 * Created by clickapps on 22/1/18.
 */
class Request {

    open class SingleOptionBuilder(protected var param: AlertParam) {

        fun message(message: String): SingleOptionBuilder {
            param.message = message
            return this
        }

        fun message(@StringRes resId: Int): SingleOptionBuilder {
            param.message = param.context!!.getString(resId)
            return this
        }

        fun title(title: String): SingleOptionBuilder {
            param.title = title
            return this
        }

        fun title(@StringRes resId: Int): SingleOptionBuilder {
            param.title = param.context!!.getString(resId)
            return this
        }

        fun icon(@DrawableRes icon: Int): SingleOptionBuilder {
            param.drawable = ContextCompat.getDrawable(param.context!!, icon)
            return this
        }

        fun icon(drawable: Drawable): SingleOptionBuilder {
            param.drawable = drawable
            return this
        }

        fun positiveButtonColor(@ColorRes resId: Int): SingleOptionBuilder {
            param.positiveBtnColor = resId
            return this
        }

        fun typeface(typeface: String): SingleOptionBuilder {
            param.typeface = typeface
            return this
        }

        fun tag(tag: Int): SingleOptionBuilder {
            param.alertTaskId = tag
            return this
        }

        fun cancelable(isCancel: Boolean): SingleOptionBuilder {
            param.isCancelable = isCancel
            return this
        }

        fun style(@StyleRes style: Int): SingleOptionBuilder {
            param.style = style
            return this
        }

        fun onClick(listener: OnDialogClickListener): SingleOptionBuilder {
            param.listener = listener
            return this
        }

        protected fun addTypeface(dialog: AlertDialog) {
            try {
                //find message text mView
                val titleTextView = dialog.findViewById<View>(android.R.id.title) as TextView?
                val messageTextView = dialog.findViewById<View>(android.R.id.message) as TextView?
                val button1TextView = dialog.findViewById<View>(android.R.id.button1) as TextView?
                val button2TextView = dialog.findViewById<View>(android.R.id.button2) as TextView?
                val button3TextView = dialog.findViewById<View>(android.R.id.button3) as TextView?
                //check typeface
                val typeface: String?
                if (param.typeface.isNotEmpty()) {
                    typeface = param.typeface
                    //set title typeface
                    Alert.get().setTypeface(param.context!!, titleTextView!!, typeface)
                    //set message typeface
                    Alert.get().setTypeface(param.context!!, messageTextView!!, typeface)
                    //set button1 typeface
                    Alert.get().setTypeface(param.context!!, button1TextView!!, typeface)
                    //set button2 typeface
                    Alert.get().setTypeface(param.context!!, button2TextView!!, typeface)
                    //set button3 typeface
                    Alert.get().setTypeface(param.context!!, button3TextView!!, typeface)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        protected fun addGenericParam(): AlertDialog.Builder {
            val alert: AlertDialog.Builder
            if (param.style != -1) {
                alert = AlertDialog.Builder(param.context!!, param.style)
            } else {
                alert = AlertDialog.Builder(param.context!!)
            }
            // set title
            if (!TextUtils.isEmpty(param.title)) {
                alert.setTitle(param.title)
            }
            // set the message
            if (!TextUtils.isEmpty(param.message)) {
                alert.setMessage(param.message)
            }
            alert.setCancelable(param.isCancelable)
            // set icon
            if (param.drawable != null) {
                alert.setIcon(param.drawable)
            }
            // set Positive button functionality
            if (!TextUtils.isEmpty(param.positiveButton)) {
                alert.setPositiveButton(param.positiveButton,
                        DialogClick(param, OnDialogClickListener.Button.POSITIVE))
            }
            return alert
        }

        open fun show() {
            val alert = addGenericParam()
            //create dialog
            val dialog = alert.create()
            dialog.setOnShowListener {
                if (param.positiveBtnColor != -1) {
                    dialog.getButton(DialogInterface.BUTTON_POSITIVE)
                            .setTextColor(ContextCompat.getColorStateList(param.context!!, param.positiveBtnColor))
                }
            }
            //display dialog
            dialog.show()
            addTypeface(dialog)
        }
    }

    class DoubleOptionBuilder(param: AlertParam) : SingleOptionBuilder(param) {

        fun negativeButtonColor(@ColorRes resId: Int): DoubleOptionBuilder {
            param.negativeBtnColor = resId
            return this
        }

        override fun show() {
            val alert = addGenericParam()
            // set Negative button functionality
            if (!TextUtils.isEmpty(param.negativeButton)) {
                alert.setNegativeButton(param.negativeButton,
                        DialogClick(param, OnDialogClickListener.Button.NEGATIVE))
            }
            //create dialog
            val dialog = alert.create()
            dialog.setOnShowListener {
                if (param.positiveBtnColor != -1) {
                    dialog.getButton(DialogInterface.BUTTON_POSITIVE)
                            .setTextColor(ContextCompat.getColorStateList(param.context!!, param.positiveBtnColor))
                }
                if (param.negativeBtnColor != -1) {
                    dialog.getButton(DialogInterface.BUTTON_NEGATIVE)
                            .setTextColor(ContextCompat.getColorStateList(param.context!!, param.negativeBtnColor))
                }
            }
            //display dialog
            dialog.show()
            addTypeface(dialog)
        }
    }

    class ListOptionBuilder(private val param: AlertParam) {

        fun title(title: String): ListOptionBuilder {
            param.title = title
            return this
        }

        fun title(@StringRes resId: Int): ListOptionBuilder {
            param.title = param.context!!.getString(resId)
            return this
        }

        fun icon(@DrawableRes icon: Int): ListOptionBuilder {
            param.drawable = ContextCompat.getDrawable(param.context!!, icon)
            return this
        }

        fun icon(drawable: Drawable): ListOptionBuilder {
            param.drawable = drawable
            return this
        }

        fun typeface(typeface: String): ListOptionBuilder {
            param.typeface = typeface
            return this
        }

        fun tag(tag: Int): ListOptionBuilder {
            param.alertTaskId = tag
            return this
        }

        fun cancelable(isCancel: Boolean): ListOptionBuilder {
            param.isCancelable = isCancel
            return this
        }

        fun style(@StyleRes style: Int): ListOptionBuilder {
            param.style = style
            return this
        }

        fun onClick(listener: OnDialogListClickListener): ListOptionBuilder {
            param.onDialogListClickListener = listener
            return this
        }

        fun show() {
            val alert: AlertDialog.Builder
            if (param.style != -1) {
                alert = AlertDialog.Builder(param.context!!, param.style)
            } else {
                alert = AlertDialog.Builder(param.context!!)
            }
            // set title
            if (!TextUtils.isEmpty(param.title)) {
                alert.setTitle(param.title)
            }
            alert.setCancelable(param.isCancelable)
            // set icon
            if (param.drawable != null) {
                alert.setIcon(param.drawable)
            }
            alert.setItems(param.list, DialogListClick(param))
            //create dialog
            val dialog = alert.create()
            //display dialog
            dialog.show()
            try {
                //find message text mView
                val titleTextView = dialog.findViewById<View>(android.R.id.title) as TextView?
                val messageTextView = dialog.findViewById<View>(android.R.id.message) as TextView?
                val button1TextView = dialog.findViewById<View>(android.R.id.button1) as TextView?
                val button2TextView = dialog.findViewById<View>(android.R.id.button2) as TextView?
                val button3TextView = dialog.findViewById<View>(android.R.id.button3) as TextView?
                //check typeface
                val typeface: String?
                if (!TextUtils.isEmpty(param.typeface)) {
                    typeface = param.typeface
                    //set title typeface
                    Alert.get().setTypeface(param.context!!, titleTextView!!, typeface!!)
                    //set message typeface
                    Alert.get().setTypeface(param.context!!, messageTextView!!, typeface)
                    //set button1 typeface
                    Alert.get().setTypeface(param.context!!, button1TextView!!, typeface)
                    //set button2 typeface
                    Alert.get().setTypeface(param.context!!, button2TextView!!, typeface)
                    //set button3 typeface
                    Alert.get().setTypeface(param.context!!, button3TextView!!, typeface)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

    }
}
