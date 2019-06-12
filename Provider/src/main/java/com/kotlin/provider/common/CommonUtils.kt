package com.kotlin.provider.common

import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.common.BaseConstant
import com.kotlin.base.ext.loge
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.router.RouterPath

/*
    顶级函数，判断是否登录
 */
fun isLogin(): Boolean {


    loge("是否登录 ${AppPrefsUtils.getInt(BaseConstant.KEY_SP_TOKEN) != 0}")
    return AppPrefsUtils.getInt(BaseConstant.KEY_SP_TOKEN) != 0
}

/*
    如果已经登录，进行传入的方法处理
    如果没有登录，进入登录界面
 */
fun afterLogin(method: () -> Unit) {
    if (isLogin()) {
        method()
    } else {
        ARouter.getInstance().build(RouterPath.UserCenter.PATH_LOGIN).navigation()

    }
}
