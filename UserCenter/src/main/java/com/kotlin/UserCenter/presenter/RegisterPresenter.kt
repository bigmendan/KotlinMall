package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.UserCenter.ui.service.impl.UserServiceImpl
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import com.kotlin.base.rx.BaseSubscriber
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * time   :  2019/4/8
 * author :  Z
 * des    :
 */
class RegisterPresenter : BasePresenter<RegisterView>() {


    fun register(mobile: String, verifyCode: String, pwd: String) {

        // 业务逻辑
        // Observable 被观察者   对应一个观察者  Observer
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



