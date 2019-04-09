package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.UserCenter.ui.service.impl.UserServiceImpl
import com.kotlin.base.presenter.BasePresenter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
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
        val userService = UserServiceImpl()
        userService.register(mobile, verifyCode, pwd)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object : Observer<Boolean> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: Boolean) {
                    Log.e("===", "执行onNext()")
                    mView.onRegisterResult(t)
                }

                override fun onError(e: Throwable) {
                }

            })


    }
}


