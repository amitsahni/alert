package com.dialog;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;

/**
 * Created by clickapps on 2/11/17.
 */

public class DialogBuilder {

    private AlertParam param;

    public DialogBuilder(@NonNull Context context) {
        param = new AlertParam();
        param.context = context;
    }


    public Request.SingleOptionBuilder asSingleOption(@NonNull String positiveButton) {
        param.positiveButton = positiveButton;
        param.dialogType = AlertParam.DialogType.SINGLE_OPTION;
        return new Request.SingleOptionBuilder(param);
    }

    public Request.SingleOptionBuilder asSingleOption(@StringRes int positiveButton) {
        param.positiveButton = param.context.getString(positiveButton);
        param.dialogType = AlertParam.DialogType.SINGLE_OPTION;
        return new Request.SingleOptionBuilder(param);
    }

    public Request.DoubleOptionBuilder asDoubleOption(@NonNull String positiveButton,
                                                      @NonNull String negativeButton) {
        param.positiveButton = positiveButton;
        param.negativeButton = negativeButton;
        param.dialogType = AlertParam.DialogType.DOUBLE_OPTION;
        return new Request.DoubleOptionBuilder(param);
    }

    public Request.DoubleOptionBuilder asDoubleOption(@StringRes int positiveButton,
                                                      @StringRes int negativeButton) {
        param.positiveButton = param.context.getString(positiveButton);
        param.negativeButton = param.context.getString(negativeButton);
        param.dialogType = AlertParam.DialogType.DOUBLE_OPTION;
        return new Request.DoubleOptionBuilder(param);
    }

    public Request.ListOptionBuilder asList(@NonNull String... list) {
        param.list = list;
        param.dialogType = AlertParam.DialogType.DIALOG_LIST;
        return new Request.ListOptionBuilder(param);
    }
}
