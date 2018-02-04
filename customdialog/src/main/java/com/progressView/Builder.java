package com.progressView;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by amit on 4/2/18.
 */

public class Builder {
    private DialogParam param;

    public Builder(@NonNull Context context) {
        param = new DialogParam();
        param.context = context;
    }

    public RequestBuilder.ViewRequest view(int layoutId) {
        param.view = LayoutInflater.from(param.context).inflate(layoutId, null);
        return new RequestBuilder.ViewRequest(param);
    }

    public RequestBuilder.ViewRequest view(@NonNull View view) {
        param.view = view;
        return new RequestBuilder.ViewRequest(param);
    }

}
