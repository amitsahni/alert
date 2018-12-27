package com.dialog

import android.content.DialogInterface

/**
 * Created by clickapps on 22/1/18.
 */

class DialogClick(private val alertParam: AlertParam, private val buttonType: OnDialogClickListener.Button) : DialogInterface.OnClickListener {

    override fun onClick(dialog: DialogInterface, which: Int) {
        alertParam.listener?.onClick(
                alertParam.alertTaskId,
                dialog, which, buttonType)
    }
}