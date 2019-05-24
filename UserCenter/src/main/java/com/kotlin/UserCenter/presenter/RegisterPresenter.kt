package com.kotlin.UserCenter.presenter

import com.kotlin.UserCenter.data.module.UserRegister
import com.kotlin.UserCenter.data.respository.UserRepository
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import javax.inject.Inject


/**
 * time   :  2019/4/8
 * author :  Z
 * des    :  引入dagger 添加 @Inject 注解 ;
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var repository: UserRepository


    // 封装了响应体
    fun register(username: String, password: String, repassword: String) {


        repository.register(username, password, repassword)
            .execute(object : BaseObserver<UserRegister>(mView) {
                override fun onSuccess(t: UserRegister?) {

                    mView.onRegisterResult("注册成功")
                }

            })


    }


}



