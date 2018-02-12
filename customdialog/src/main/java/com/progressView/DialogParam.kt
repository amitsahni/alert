package com.progressView

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.StyleRes
import android.view.View


/**
 * The type Alert param.
 */
class DialogParam {
    internal var context: Context? = null
    internal var view: View? = null
    @IdRes
    internal var ids: IntArray? = null
    @StyleRes
    internal var theme = -1
    internal var clickListener: View.OnClickListener? = null
    internal var isCancelable = true
}
