package com.progressView

import android.content.Context
import android.view.LayoutInflater
import android.view.View

/**
 * Created by amit on 4/2/18.
 */

class Builder(context: Context) {
    private val param: DialogParam = DialogParam()

    init {
        param.context = context
    }

    fun view(layoutId: Int): RequestBuilder.ViewRequest {
        param.view = LayoutInflater.from(param.context).inflate(layoutId, null)
        return RequestBuilder.ViewRequest(param)
    }

    fun view(view: View): RequestBuilder.ViewRequest {
        param.view = view
        return RequestBuilder.ViewRequest(param)
    }

}
