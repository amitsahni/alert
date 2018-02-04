package com.progressView;

import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
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

        public void build() {
            new CustomView(param).show();
        }
    }
}
