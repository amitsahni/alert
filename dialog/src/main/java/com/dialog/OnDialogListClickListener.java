package com.dialog;

import android.content.DialogInterface;

/**
 * Created by clickapps on 22/1/18.
 */

public interface OnDialogListClickListener {

    void onClick(int tag, DialogInterface dialog, int pos, String value);
}
