package com.dialog;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.support.annotation.StyleRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.widget.TextView;

import com.alertutil.alert.Alert;

/**
 * Created by clickapps on 22/1/18.
 */
@SuppressWarnings("unchecked")
public class Request {

    public static class SingleOptionBuilder<T extends SingleOptionBuilder> {
        AlertParam param;

        public SingleOptionBuilder(AlertParam param) {
            this.param = param;
        }

        public T message(@NonNull String message) {
            param.message = message;
            return (T) this;
        }

        public T message(@StringRes int resId) {
            param.message = param.context.getString(resId);
            return (T) this;
        }

        public T title(@NonNull String title) {
            param.title = title;
            return (T) this;
        }

        public T title(@StringRes int resId) {
            param.title = param.context.getString(resId);
            return (T) this;
        }

        public T icon(@DrawableRes int icon) {
            param.drawable = ContextCompat.getDrawable(param.context, icon);
            return (T) this;
        }

        public T icon(@NonNull Drawable drawable) {
            param.drawable = drawable;
            return (T) this;
        }

        public T positiveButtonColor(@ColorRes int resId) {
            param.positiveBtnColor = resId;
            return (T) this;
        }

        public T typeface(@NonNull String typeface) {
            param.typeface = typeface;
            return (T) this;
        }

        public T tag(int tag) {
            param.alertTaskId = tag;
            return (T) this;
        }

        public T cancelable(boolean isCancel) {
            param.isCancelable = isCancel;
            return (T) this;
        }

        public T style(@StyleRes int style) {
            param.style = style;
            return (T) this;
        }

        public T onClick(@NonNull OnDialogClickListener listener) {
            param.listener = listener;
            return (T) this;
        }

        void addTypeface(@NonNull AlertDialog dialog) {
            try {
                //find message text mView
                TextView titleTextView = (TextView) dialog.findViewById(android.R.id.title);
                TextView messageTextView = (TextView) dialog.findViewById(android.R.id.message);
                TextView button1TextView = (TextView) dialog.findViewById(android.R.id.button1);
                TextView button2TextView = (TextView) dialog.findViewById(android.R.id.button2);
                TextView button3TextView = (TextView) dialog.findViewById(android.R.id.button3);
                //check typeface
                String typeface;
                if (!TextUtils.isEmpty(param.typeface)) {
                    typeface = param.typeface;
                    //set title typeface
                    Alert.get().setTypeface(param.context, titleTextView, typeface);
                    //set message typeface
                    Alert.get().setTypeface(param.context, messageTextView, typeface);
                    //set button1 typeface
                    Alert.get().setTypeface(param.context, button1TextView, typeface);
                    //set button2 typeface
                    Alert.get().setTypeface(param.context, button2TextView, typeface);
                    //set button3 typeface
                    Alert.get().setTypeface(param.context, button3TextView, typeface);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        AlertDialog.Builder addGenericParam() {
            AlertDialog.Builder alert;
            if (param.style != -1) {
                alert = new AlertDialog.Builder(param.context, param.style);
            } else {
                alert = new AlertDialog.Builder(param.context);
            }
            // set title
            if (!TextUtils.isEmpty(param.title)) {
                alert.setTitle(param.title);
            }
            // set the message
            if (!TextUtils.isEmpty(param.message)) {
                alert.setMessage(param.message);
            }
            alert.setCancelable(param.isCancelable);
            // set icon
            if (param.drawable != null) {
                alert.setIcon(param.drawable);
            }
            // set Positive button functionality
            if (!TextUtils.isEmpty(param.positiveButton)) {
                alert.setPositiveButton(param.positiveButton,
                        new DialogClick(param, OnDialogClickListener.Button.POSITIVE));
            }
            return alert;
        }

        public void show() {
            AlertDialog.Builder alert = addGenericParam();
            //create dialog
            final AlertDialog dialog = alert.create();
            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    if (param.positiveBtnColor != -1) {
                        dialog.getButton(DialogInterface.BUTTON_POSITIVE)
                                .setTextColor(ContextCompat.getColorStateList(param.context, param.positiveBtnColor));
                    }
                }
            });
            //display dialog
            dialog.show();
            addTypeface(dialog);
        }
    }

    public static class DoubleOptionBuilder extends SingleOptionBuilder<DoubleOptionBuilder> {

        public DoubleOptionBuilder(AlertParam param) {
            super(param);
        }

        public DoubleOptionBuilder negativeButtonColor(@ColorRes int resId) {
            param.negativeBtnColor = resId;
            return this;
        }

        @Override
        public void show() {
            AlertDialog.Builder alert = addGenericParam();
            // set Negative button functionality
            if (!TextUtils.isEmpty(param.negativeButton)) {
                alert.setNegativeButton(param.negativeButton,
                        new DialogClick(param, OnDialogClickListener.Button.NEGATIVE));
            }
            //create dialog
            final AlertDialog dialog = alert.create();
            dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface dialogInterface) {
                    if (param.positiveBtnColor != -1) {
                        dialog.getButton(DialogInterface.BUTTON_POSITIVE)
                                .setTextColor(ContextCompat.getColorStateList(param.context, param.positiveBtnColor));
                    }
                    if (param.negativeBtnColor != -1) {
                        dialog.getButton(DialogInterface.BUTTON_NEGATIVE)
                                .setTextColor(ContextCompat.getColorStateList(param.context, param.negativeBtnColor));
                    }
                }
            });
            //display dialog
            dialog.show();
            addTypeface(dialog);
        }
    }

    public static class ListOptionBuilder<T extends ListOptionBuilder> {
        private AlertParam param;

        public ListOptionBuilder(AlertParam param) {
            this.param = param;
        }

        public T title(@NonNull String title) {
            param.title = title;
            return (T) this;
        }

        public T title(@StringRes int resId) {
            param.title = param.context.getString(resId);
            return (T) this;
        }

        public T icon(@DrawableRes int icon) {
            param.drawable = ContextCompat.getDrawable(param.context, icon);
            return (T) this;
        }

        public T icon(@NonNull Drawable drawable) {
            param.drawable = drawable;
            return (T) this;
        }

        public T typeface(@NonNull String typeface) {
            param.typeface = typeface;
            return (T) this;
        }

        public T tag(int tag) {
            param.alertTaskId = tag;
            return (T) this;
        }

        public T cancelable(boolean isCancel) {
            param.isCancelable = isCancel;
            return (T) this;
        }

        public T style(@StyleRes int style) {
            param.style = style;
            return (T) this;
        }

        public T onClick(@NonNull OnDialogListClickListener listener) {
            param.onDialogListClickListener = listener;
            return (T) this;
        }

        public void show() {
            AlertDialog.Builder alert;
            if (param.style != -1) {
                alert = new AlertDialog.Builder(param.context, param.style);
            } else {
                alert = new AlertDialog.Builder(param.context);
            }
            // set title
            if (!TextUtils.isEmpty(param.title)) {
                alert.setTitle(param.title);
            }
            alert.setCancelable(param.isCancelable);
            // set icon
            if (param.drawable != null) {
                alert.setIcon(param.drawable);
            }
            alert.setItems(param.list, new DialogListClick(param));
            //create dialog
            final AlertDialog dialog = alert.create();
            //display dialog
            dialog.show();
            try {
                //find message text mView
                TextView titleTextView = (TextView) dialog.findViewById(android.R.id.title);
                TextView messageTextView = (TextView) dialog.findViewById(android.R.id.message);
                TextView button1TextView = (TextView) dialog.findViewById(android.R.id.button1);
                TextView button2TextView = (TextView) dialog.findViewById(android.R.id.button2);
                TextView button3TextView = (TextView) dialog.findViewById(android.R.id.button3);
                //check typeface
                String typeface;
                if (!TextUtils.isEmpty(param.typeface)) {
                    typeface = param.typeface;
                    //set title typeface
                    Alert.get().setTypeface(param.context, titleTextView, typeface);
                    //set message typeface
                    Alert.get().setTypeface(param.context, messageTextView, typeface);
                    //set button1 typeface
                    Alert.get().setTypeface(param.context, button1TextView, typeface);
                    //set button2 typeface
                    Alert.get().setTypeface(param.context, button2TextView, typeface);
                    //set button3 typeface
                    Alert.get().setTypeface(param.context, button3TextView, typeface);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
