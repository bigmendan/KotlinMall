package com.kotlin.UserCenter.presenter.view

import com.kotlin.UserCenter.data.module.UserInfo
import com.kotlin.base.presenter.view.BaseView

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/30 10:46:24
 * @Des    :
 */
interface LoginView : BaseView {

    fun loginResult(info: UserInfo)
}