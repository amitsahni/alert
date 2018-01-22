package com.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;


/**
 * The type Alert param.
 */
public class AlertParam {

    /**
     * The Message.
     */
    String message = "";
    /**
     * The Context.
     */
    Context context;
    /**
     * The Title.
     */
    String title = "";
    /**
     * The Alert task id.
     */
    int alertTaskId = -1;
    /**
     * The Dialog type.
     */
    DialogType dialogType = DialogType.SINGLE_OPTION;
    /**
     * The Listener.
     */
    OnDialogClickListener listener;

    OnDialogListClickListener onDialogListClickListener;
    /**
     * The theme for Alert dialog
     */
    int style = -1;
    /**
     * The Drawable.
     */
    Drawable drawable = null;
    /**
     * The Positive button.
     */
    String positiveButton, /**
     * The Negative button.
     */
    negativeButton;

    int positiveBtnColor = -1, negativeBtnColor = -1;
    /**
     * The Bundle.
     */
    Bundle bundle;
    /**
     * The Is cancelable.
     */
    boolean isCancelable = true;
    /**
     * The List.
     */
    String[] list;

    /**
     * The enum Dialog type.
     */
    public enum DialogType {
        /**
         * Single option dialog type.
         */
        SINGLE_OPTION, /**
         * Double option dialog type.
         */
        DOUBLE_OPTION, /**
         * Dialog list dialog type.
         */
        DIALOG_LIST
    }

    /**
     * The Activity context.
     */
    /*Typeface for the specific alert*/
    String typeface;
}
