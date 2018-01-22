package com.dialog;

import android.content.DialogInterface;

/**
 * Created by clickapps on 22/1/18.
 */

public class DialogListClick implements DialogInterface.OnClickListener {
    private AlertParam alertParam;

    /**
     * Instantiates a new On dialog click.
     *
     * @param alertParam the alert param
     */
    public DialogListClick(AlertParam alertParam) {
        this.alertParam = alertParam;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (alertParam.onDialogListClickListener == null)
            return;
        alertParam.onDialogListClickListener.onClick(
                alertParam.alertTaskId,
                dialog, which, alertParam.list[which]);
    }
}