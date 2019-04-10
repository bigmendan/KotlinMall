package com.kotlin.UserCenter.ui.service.impl

import com.kotlin.UserCenter.ui.service.UserService
import io.reactivex.Observable

/**
 * time   :  2019/4/9
 * author :  Z
 * des    :
 */
class UserServiceImpl : UserService {

    // 注册流程的具体实现
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return Observable.just(true)

    }
}