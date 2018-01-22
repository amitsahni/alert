package com.dialog;

import android.content.DialogInterface;

/**
 * Created by clickapps on 22/1/18.
 */

public class DialogClick implements DialogInterface.OnClickListener {
    private AlertParam alertParam;
    private OnDialogClickListener.Button buttonType;

    /**
     * Instantiates a new On dialog click.
     *
     * @param alertParam the alert param
     * @param buttonType the button type
     */
    public DialogClick(AlertParam alertParam, OnDialogClickListener.Button buttonType) {
        this.alertParam = alertParam;
        this.buttonType = buttonType;
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (alertParam.listener == null)
            return;
//        if (buttonType == 3) {
//            alertParam.bundle = new Bundle();
//            alertParam.bundle.putString(AlertParam.ITEM, alertParam.list[which]);
//            alertParam.bundle.putInt(AlertParam.POS, which);
//        }
        alertParam.listener.onClick(
                alertParam.alertTaskId,
                dialog, which, buttonType);
    }
}