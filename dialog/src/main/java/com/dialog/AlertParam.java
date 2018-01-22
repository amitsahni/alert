package com.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.alertutil.dialog.OnDialogProcess;


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
     * The Message res id.
     */
    int messageResId = -1;
    /**
     * The constant ITEM.
     */
//    Dialog class
    public static final String ITEM = "item";
    public static final String POS = "pos";
    /**
     * The Title.
     */
    String title = "";
    /**
     * The Title res id.
     */
    int titleResId = -1;
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
    OnDialogProcess listener;
    /**
     * The Icon.
     */
    int icon = -1;
    /**
     * The theme for Alert dialog
     */
    int style = -1;
    /**
     * The Drawable.
     */
    Drawable drawable;
    /**
     * The Positive button.
     */
    String positiveButton, /**
     * The Negative button.
     */
    negativeButton;
    /**
     * The Positive button res id.
     */
    int positiveButtonResId = -1, /**
     * The Negative button res id.
     */
    negativeButtonResId = -1, positiveBtnColor = -1, negativeBtnColor = -1;
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
