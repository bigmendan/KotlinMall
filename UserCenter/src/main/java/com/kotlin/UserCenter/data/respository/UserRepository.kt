package com.kotlin.UserCenter.data.respository

import com.kotlin.UserCenter.data.api.UserApi
import com.kotlin.UserCenter.data.module.UserInfo
import com.kotlin.UserCenter.data.module.UserRegister
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:39:50
 * @Des    :  这个文件是真正做访问的
 */
class UserRepository @Inject constructor() {


    /**
     *  注册
     */
    fun register(mobile: String, verifyCode: String, pwd: String)
            : Observable<BaseResp<UserRegister>> {

        return RetrofitFactory.instance
            .create(UserApi::class.java)
            .register(mobile, verifyCode, pwd)

    }


    /**
     *  登录 ;
     */
    fun login(username: String, password: String)
            : Observable<BaseResp<UserInfo>> {

        return RetrofitFactory.instance
            .create(UserApi::class.java)
            .login(username, password)
    }


    private fun service(): UserApi {
        return RetrofitFactory.instance
            .create(UserApi::class.java)
    }

}