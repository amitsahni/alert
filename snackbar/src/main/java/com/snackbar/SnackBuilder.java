package com.snackbar;

import android.app.Activity;
import android.support.annotation.ColorRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

/**
 * Created by clickapps on 2/11/17.
 */

public class SnackBuilder {

    private SnackBarParam param;
    private Snackbar snackbar;

    public SnackBuilder(@NonNull Activity context, @StringRes int resId) {
        param = new SnackBarParam();
        param.context = context;
        param.message = context.getString(resId);
    }

    public SnackBuilder(@NonNull Activity context, @NonNull String msg) {
        param = new SnackBarParam();
        param.context = context;
        param.message = msg;
    }

    public SnackBuilder(@NonNull Activity context, @StringRes int resId, @ColorRes int backgroundColor) {
        param = new SnackBarParam();
        param.context = context;
        param.message = context.getString(resId);
        param.actionBackgroundResId = backgroundColor;
    }

    public SnackBuilder(@NonNull Activity context, String msg, @ColorRes int backgroundColor) {
        param = new SnackBarParam();
        param.context = context;
        param.message = msg;
        param.actionBackgroundResId = backgroundColor;
    }

    public SnackBuilder actionMessage(String actionMessage) {
        param.actionMessage = actionMessage;
        return this;
    }

    public SnackBuilder actionMessage(@StringRes int resId) {
        param.actionMessage = param.context.getString(resId);
        return this;
    }

    public SnackBuilder view(View view) {
        param.snackBarView = view;
        param.snackBarView.setFocusable(false);
        return this;
    }

    public SnackBuilder listener(OnSnackBarActionListener l) {
        param.onSnackBarActionListener = l;
        return this;
    }

    public SnackBuilder actionColor(@ColorRes int resId) {
        param.actionColorResId = resId;
        return this;
    }

    public SnackBuilder textColor(@ColorRes int resId) {
        param.textColor = resId;
        return this;
    }

    public SnackBuilder duration(int duration) {
        param.snackBarDuration = duration;
        return this;
    }

    public SnackBuilder backgroundColor(@ColorRes int color) {
        param.actionBackgroundResId = color;
        return this;
    }

    public SnackBuilder info() {
        param.actionBackgroundResId = SnackBarParam.blue;
        return this;
    }

    public SnackBuilder confirm() {
        param.actionBackgroundResId = SnackBarParam.green;
        return this;
    }

    public SnackBuilder warning() {
        param.actionBackgroundResId = SnackBarParam.orange;
        return this;
    }

    public SnackBuilder alert() {
        param.actionBackgroundResId = SnackBarParam.red;
        return this;
    }

    public SnackBuilder tag(int tag) {
        param.alertTaskId = tag;
        return this;
    }

    public SnackBuilder actionMessageMaxLines(int maxLines) {
        param.actionMessageMaxLine = maxLines;
        return this;
    }

    @SuppressWarnings("Typeface must be defined in assets")
    public SnackBuilder typeface(@NonNull String typeface) {
        param.typeface = typeface;
        return this;
    }

    /**
     * Show.
     */
    public SnackBarParam show() {
        if (snackbar != null)
            snackbar.dismiss();
        if (param.context == null) {
            return param;
        }
        if (param.snackBarView == null) {
            param.snackBarView = param.context.findViewById(android.R.id.content);
        }
        snackbar = Snackbar.make(param.snackBarView, "", param.snackBarDuration);

        // Checked for Message
        if (!TextUtils.isEmpty(param.message)) {
            snackbar.setText(param.message);
        } else {
            snackbar.setText("");
        }

        // checked for ActionMessage
        if (!TextUtils.isEmpty(param.actionMessage)) {
            snackbar.setAction(param.actionMessage, new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (param.onSnackBarActionListener == null) {
                        return;
                    }
                    param.onSnackBarActionListener.onSnackBarActionClicked(param.alertTaskId, v);
                }
            });
        } else {
            snackbar.setAction("", null);
        }
        // checked for actionMessagecolor
        if (param.actionColorResId != -1) {
            snackbar.setActionTextColor(ContextCompat.getColor(param.context, param.actionColorResId));
        }
        TextView tv = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_text);
        TextView tva = (TextView) snackbar.getView().findViewById(android.support.design.R.id.snackbar_action);
        if (param.actionMessageMaxLine != -1)
            tv.setMaxLines(param.actionMessageMaxLine);
        if (param.textColor != -1) {
            tv.setTextColor(ContextCompat.getColorStateList(param.context, param.textColor));
        }
        if (param.actionBackgroundResId != -1)
            snackbar.getView().setBackgroundColor(ContextCompat.getColor(param.context, param.actionBackgroundResId));
        //check typeface
        String typeface;
        if (!TextUtils.isEmpty(param.typeface)) {
            typeface = param.typeface;
            //set message typeface
            SnackBar.get().setTypeface(param.context, tv, typeface);
            //set action typeface
            SnackBar.get().setTypeface(param.context, tva, typeface);
        }
        snackbar.show();
        return param;
    }

}
