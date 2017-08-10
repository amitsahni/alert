package com.alertutil.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;

/**
 * Created by clickapps on 3/7/15.
 */
public class ProgressViewApplication extends BaseDialog {

    /**
     * Instantiates a new Progress mView application.
     *
     * @param context the context
     */
    public ProgressViewApplication(Context context, int layoutId) {
        super(context);
        this.layoutId = layoutId;
    }


    private int layoutId;


    /**
     * Instantiates a new Custom dialog.
     *
     * @param context the context
     * @param theme   the theme
     */
    public ProgressViewApplication(Context context, int theme, int layoutId) {
        super(context, theme);
        this.layoutId = layoutId;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(this.layoutId);
//            textView = (BaseTextView) findViewById(R.id.dialog_progress_baseTextView);
//            progressBar = (BaseProgressBar) findViewById(R.id.dialog_progress_baseProgressBar);
    }
}
