package com.dialog

import android.content.DialogInterface

/**
 * Created by clickapps on 22/1/18.
 */

interface OnDialogListClickListener {

    fun onClick(tag: Int, dialog: DialogInterface, pos: Int, value: String)
}
