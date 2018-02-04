package com.progressView;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.StyleRes;
import android.view.View;


/**
 * The type Alert param.
 */
public class DialogParam {
    Context context;
    View view;
    @IdRes
    int[] ids;
    @StyleRes
    int theme = -1;
    View.OnClickListener clickListener;
    boolean isCancelable = true;
}
