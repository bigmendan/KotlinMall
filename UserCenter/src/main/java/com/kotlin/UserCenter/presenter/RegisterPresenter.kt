package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.UserCenter.ui.service.impl.UserServiceImpl
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver

/**
 * time   :  2019/4/8
 * author :  Z
 * des    :
 */
class RegisterPresenter : BasePresenter<RegisterView>() {


    fun register(mobile: String, verifyCode: String, pwd: String) {

        // 业务逻辑
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
            .execute(object : BaseObserver<Boolean>() {
                override fun onNext(t: Boolean) {

                    mView.onRegisterResult(true)
                }

                override fun onError(e: Throwable) {

                }


            })


    }
}


