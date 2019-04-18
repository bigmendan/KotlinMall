package com.kotlin.UserCenter.data.respository

import com.kotlin.UserCenter.data.api.UserApi
import com.kotlin.UserCenter.data.protocol.Register2Req
import com.kotlin.UserCenter.data.protocol.RegisterReq
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody
import java.util.*
import javax.inject.Inject

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:39:50
 * @Des    :  这个文件是真正做访问的
 */
class UserRepository @Inject constructor() {

    // 将 Retrofit 做网络请求 封装起来
    fun register(username: String, password: String, repassword: String)
            : Observable<BaseResp<String>> {

        return RetrofitFactory.instance
            .create(UserApi::class.java)
            .register(RegisterReq(username, password, repassword))

    }

}