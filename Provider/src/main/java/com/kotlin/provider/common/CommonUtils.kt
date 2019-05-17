package com.kotlin.provider.common

import android.util.Log
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.router.RouterPath

/*
    顶级函数，判断是否登录
 */
fun isLogined(): Boolean {

    Log.e("===ISlogin = ", " == token = ${AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN)}")

    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()
}

/*
    如果已经登录，进行传入的方法处理
    如果没有登录，进入登录界面
 */
fun afterLogin(method: () -> Unit) {
    if (isLogined()) {
        method()
    } else {
        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()

    }
}
