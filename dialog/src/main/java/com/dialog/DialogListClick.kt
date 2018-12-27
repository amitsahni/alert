package com.dialog

import android.content.DialogInterface

/**
 * Created by clickapps on 22/1/18.
 */

class DialogListClick(private val alertParam: AlertParam) : DialogInterface.OnClickListener {

    override fun onClick(dialog: DialogInterface, which: Int) {
        alertParam.onDialogListClickListener?.onClick(
                alertParam.alertTaskId,
                dialog, which, alertParam.list[which])
    }
}