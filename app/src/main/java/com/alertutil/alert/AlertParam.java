package com.alertutil.alert;

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
    protected String message = "";
    /**
     * The Context.
     */
    protected Context context;
    /**
     * The Message res id.
     */
    protected int messageResId = -1;
    /**
     * The constant ITEM.
     */
//    Dialog class
    public static final String ITEM = "item";
    public static final String POS = "pos";
    /**
     * The Title.
     */
    protected String title = "";
    /**
     * The Title res id.
     */
    protected int titleResId = -1;
    /**
     * The Alert task id.
     */
    protected int alertTaskId = -1;
    /**
     * The Dialog type.
     */
    protected DialogType dialogType = DialogType.SINGLE_OPTION;
    /**
     * The Listener.
     */
    protected OnDialogProcess listener;
    /**
     * The Icon.
     */
    protected int icon = -1;
    /**
     * The theme for Alert dialog
     */
    protected int style = -1;
    /**
     * The Drawable.
     */
    protected Drawable drawable;
    /**
     * The Positive button.
     */
    protected String positiveButton, /**
     * The Negative button.
     */
    negativeButton;
    /**
     * The Positive button res id.
     */
    protected int positiveButtonResId = -1, /**
     * The Negative button res id.
     */
    negativeButtonResId = -1, positiveBtnColor = -1, negativeBtnColor = -1;
    /**
     * The Bundle.
     */
    protected Bundle bundle;
    /**
     * The Is cancelable.
     */
    protected boolean isCancelable = true;
    /**
     * The List.
     */
    protected String[] list;

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
    protected String typeface;

}
