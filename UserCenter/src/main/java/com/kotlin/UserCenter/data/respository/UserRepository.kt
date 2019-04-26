package com.kotlin.UserCenter.data.respository

import com.kotlin.UserCenter.data.api.UserApi
import com.kotlin.UserCenter.data.module.UserRegisterModel
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:39:50
 * @Des    :  这个文件是真正做访问的
 */
class UserRepository @Inject constructor() {



    fun register(mobile: String, verifyCode: String, pwd: String)
            : Observable<BaseResp<UserRegisterModel>> {

        return RetrofitFactory.instance
            .create(UserApi::class.java)
            .register(mobile, verifyCode, pwd)

    }


}