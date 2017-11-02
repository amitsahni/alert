package com.alertutil.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/**
 * Created by clickapps on 3/7/15.
 */
public class ProgressView extends BaseProgressDialog {
    private View view;

    /**
     * Instantiates a new Progress mView application.
     *
     * @param context the context
     */
    public ProgressView(Context context, int layoutId) {
        super(context);
        view = LayoutInflater.from(context).inflate(layoutId, null);
    }

    /**
     * Instantiates a new Progress mView application.
     *
     * @param context the context
     */
    public ProgressView(Context context, View view) {
        super(context);
        this.view = view;
    }

    /**
     * Instantiates a new Custom dialog.
     *
     * @param context the context
     * @param theme   the theme
     */
    public ProgressView(Context context, int theme, int layoutId) {
        super(context, theme);
        view = LayoutInflater.from(context).inflate(layoutId, null);
    }

    /**
     * Instantiates a new Custom dialog.
     *
     * @param context the context
     * @param theme   the theme
     */
    public ProgressView(Context context, int theme, View view) {
        super(context, theme);
        this.view = view;
    }

    public View getView() {
        return view;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(this.view);
    }
}
