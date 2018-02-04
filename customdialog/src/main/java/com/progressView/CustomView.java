package com.progressView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

/**
 * Created by clickapps on 3/7/15.
 */
public class CustomView extends BaseDialog {
    DialogParam param;

    public CustomView(DialogParam param) {
        super(param.context);
        this.param = param;
    }


    public CustomView(DialogParam param, int theme) {
        super(param.context, theme);
        this.param = param;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(this.param.view);
        param.view.setClickable(true);
        if (param.ids != null) {
            for (int id : param.ids) {
                View view = param.view.findViewById(id);
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (param.clickListener != null)
                            param.clickListener.onClick(view);
                    }
                });
            }
        }
    }

}
