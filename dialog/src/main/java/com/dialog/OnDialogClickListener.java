package com.dialog;

import android.content.DialogInterface;

/**
 * This interface is used as a call back for the dialogs
 */
public interface OnDialogClickListener {

    enum Button {
        POSITIVE,
        NEGATIVE,
        NEUTRAL
    }

    void onClick(int tag,DialogInterface dialog, int pos, Button button);

}
