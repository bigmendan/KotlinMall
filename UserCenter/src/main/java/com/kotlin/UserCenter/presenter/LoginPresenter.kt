package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.data.module.UserInfo
import com.kotlin.UserCenter.data.respository.UserRepository
import com.kotlin.UserCenter.presenter.view.LoginView
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import javax.inject.Inject

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/30 10:45:58
 * @Des    :   Presenter 的构造方法前加 @Inject 是因为 需要在 BaseView 里面拿到这个 对象 ;
 */
class LoginPresenter @Inject constructor() : BasePresenter<LoginView>() {

    @Inject
    lateinit var repository: UserRepository

    fun login(username: String, password: String) {

        repository.login(username, password)
            .execute(object : BaseObserver<UserInfo>(mView) {
                override fun onSuccess(t: UserInfo?) {
                    mView.loginResult(t!!)
                }

            })

    }
}