package com.progressView

import android.support.annotation.IdRes
import android.support.annotation.StyleRes
import android.view.View

/**
 * Created by amit on 4/2/18.
 */

class RequestBuilder {

    class ViewRequest(internal var param: DialogParam) {

        fun onClickListener(l: View.OnClickListener, @IdRes vararg ids: Int): ViewRequest {
            this.param.ids = ids
            this.param.clickListener = l
            return this
        }

        fun theme(@StyleRes theme: Int): ViewRequest {
            this.param.theme = theme
            return this
        }

        fun cancelable(isCancelable: Boolean): ViewRequest {
            this.param.isCancelable = isCancelable
            return this
        }

        fun build() {
            val customView: CustomView
            if (param.theme == -1) {
                customView = CustomView(param)
                customView.setCancelable(param.isCancelable)
                customView.show()
            } else {
                customView = CustomView(param, param.theme)
                customView.setCancelable(param.isCancelable)
                customView.show()
            }
        }
    }
}
