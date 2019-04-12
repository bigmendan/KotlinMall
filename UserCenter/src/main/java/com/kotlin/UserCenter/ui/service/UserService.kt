package com.kotlin.UserCenter.ui.service

import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.*

/**
 * time   :  2019/4/9
 * author :  Z
 * des    :
 */
interface UserService {

    // 注册 方法
    fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean>


    // 登录 方法
    fun login(mobile: String, pwd: String): Observable<String>


    fun forget(phone: String, pwd: String): Flowable<Boolean>
}