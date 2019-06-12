package com.kotlin.base.utils

import android.content.Context
import com.kotlin.base.common.BaseApplication


fun dp2px(dpValue: Float): Int {

    var density: Float = BaseApplication.context.resources.displayMetrics.density
    return (dpValue * density + 0.5).toInt()
}


fun px2dp(pxValue: Float): Int {
    var density = BaseApplication.context.resources.displayMetrics.density
    return (pxValue / density + 0.5).toInt()
}