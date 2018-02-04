package com.progressView;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;
import android.view.View;

/**
 * Created by amit on 4/2/18.
 */

public class RequestBuilder {

    public static class ViewRequest {
        DialogParam param;

        public ViewRequest(DialogParam param) {
            this.param = param;
        }

        public ViewRequest onClickListener(@NonNull View.OnClickListener l, @IdRes int... ids) {
            this.param.ids = ids;
            this.param.clickListener = l;
            return this;
        }

        public ViewRequest theme(@StyleRes int theme) {
            this.param.theme = theme;
            return this;
        }

        public ViewRequest cancelable(boolean isCancelable) {
            this.param.isCancelable = isCancelable;
            return this;
        }

        public void build() {
            CustomView customView;
            if (param.theme == -1) {
                customView = new CustomView(param);
                customView.setCancelable(param.isCancelable);
                customView.show();
            } else {
                customView = new CustomView(param, param.theme);
                customView.setCancelable(param.isCancelable);
                customView.show();
            }
        }
    }
}
