package com.kotlin.UserCenter.ui.service

import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.*

/**
 * time   :  2019/4/9
 * author :  Z
 * des    :
 */
interface UserService {

    // 注册 方法
    fun register(mobile: String, pwd: String, rePwd: String)
            : Flowable<Boolean>

    fun register2(username: String, password: String, repassword: String)
            : Observable<ResponseBody>


}