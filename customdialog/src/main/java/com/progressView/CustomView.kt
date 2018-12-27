package com.progressView

import android.os.Bundle
import android.view.View
import android.view.Window

/**
 * Created by clickapps on 3/7/15.
 */
class CustomView : BaseDialog {
    private var param: DialogParam

    constructor(param: DialogParam) : super(param.context!!) {
        this.param = param
    }


    constructor(param: DialogParam, theme: Int) : super(param.context!!, theme) {
        this.param = param
    }

    override
    fun onCreate(savedInstanceState: Bundle?) {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        super.onCreate(savedInstanceState)
        setContentView(this.param.view)
        param.view?.isClickable = true
        param.ids?.let {
            it.map { param.view?.findViewById<View>(it) }
                    .forEach {
                        it?.setOnClickListener { view ->
                            param.clickListener?.onClick(view)
                        }
                    }
        }
    }

}
