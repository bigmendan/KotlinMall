package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.UserCenter.ui.service.UserService
import com.kotlin.UserCenter.ui.service.impl.UserServiceImpl
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import com.kotlin.base.rx.BaseSubscriber
import javax.inject.Inject


/**
 * time   :  2019/4/8
 * author :  Z
 * des    :  引入dagger 添加 @Inject 注解 ;
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserServiceImpl

    fun register(username: String, password: String, repassword: String) {

        // 业务逻辑
        // Observable 被观察者   对应一个观察者  Observer
//        val userService = UserServiceImpl()

        // 网络请求之前先开启弹窗

        mView.showLoading()

        userService.register(username, password, repassword)
            .execute(object : BaseObserver<Boolean>(mView) {
                override fun onNext(t: Boolean) {
//                    mView.onRegisterResult(true)
                }

                override fun onError(e: Throwable) {
                    Log.e("===", "请求错误 = ${e.message}")
                }

            })


    }
}



