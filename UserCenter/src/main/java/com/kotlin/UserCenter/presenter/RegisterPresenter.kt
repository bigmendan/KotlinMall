package com.kotlin.UserCenter.presenter

import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.presenter.BasePresenter

/**
 * time   :  2019/4/8
 * author :  Z
 * des    :
 */
class RegisterPresenter : BasePresenter<RegisterView>() {


    fun register(mobile: String, verifyCode: String) {

        // 业务逻辑

        mView.onRegisterResult(true)
    }
}