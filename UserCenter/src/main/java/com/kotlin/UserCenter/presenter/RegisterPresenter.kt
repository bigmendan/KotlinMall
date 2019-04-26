package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.data.module.UserRegisterModel
import com.kotlin.UserCenter.data.respository.UserRepository
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.NormalObserver
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
            .execute(object : NormalObserver<UserRegisterModel>(mView) {
                override fun onSuccess(t: UserRegisterModel?) {

                    Log.e("===onSuccess", "返回 $t")
                }

            }, lifecycleProvider)


    }


}



