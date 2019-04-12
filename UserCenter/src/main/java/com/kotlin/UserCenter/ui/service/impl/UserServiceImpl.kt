package com.kotlin.UserCenter.ui.service.impl

import com.kotlin.UserCenter.ui.service.UserService
import io.reactivex.Flowable
import io.reactivex.Observable
import org.reactivestreams.Subscriber

/**
 * time   :  2019/4/9
 * author :  Z
 * des    :
 */
class UserServiceImpl : UserService {

    override fun login(mobile: String, pwd: String): Observable<String> {
        return Observable.just("")
    }


    // 注册流程的具体实现
    override fun register(mobile: String, verifyCode: String, pwd: String): Observable<Boolean> {

        return Observable.just(true)
    }

    // 这是 RxJava2 中对背压的支持;
    override fun forget(phone: String, pwd: String): Flowable<Boolean> {
        return Flowable.just(true)
    }


}