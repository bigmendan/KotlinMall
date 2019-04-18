package com.kotlin.UserCenter.ui.service.impl

import android.util.Log
import com.kotlin.UserCenter.data.respository.UserRepository
import com.kotlin.UserCenter.ui.service.UserService
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.functions.Function
import okhttp3.ResponseBody
import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import javax.inject.Inject

/**
 * time   :  2019/4/9
 * author :  Z
 * des    :   UserServiceImpl 使用了 @Inject 注解
 */

class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository


    // 注册流程的具体实现   这里返回值是  Boolean ,
    // 但是 在真正访问文件中 的 BaseReq返回值是 String; 会用到RxJava 的 FlatMap
    override fun register(username: String, password: String, repassword: String)
            : Observable<Boolean> {

//        val repository = UserRepository()
        return repository.register(username, password, repassword)
            .flatMap(object : Function<BaseResp<String>, ObservableSource<Boolean>> {
                override fun apply(t: BaseResp<String>): ObservableSource<Boolean> {

                    Log.e("==== ", "注册结果 = $t")
                    if (t.status != 0) {
                        // 表示 失败
                        return Observable.error(BaseException(t.status, t.message))
                    }
                    return Observable.just(true)
                }

            })


    }


}