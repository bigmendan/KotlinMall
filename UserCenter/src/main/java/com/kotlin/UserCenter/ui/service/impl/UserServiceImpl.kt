package com.kotlin.UserCenter.ui.service.impl

import com.kotlin.UserCenter.data.respository.UserRepository
import com.kotlin.UserCenter.ui.service.UserService
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseException
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.functions.Function
import okhttp3.ResponseBody
import org.reactivestreams.Publisher
import org.reactivestreams.Subscriber
import javax.inject.Inject

/**
 * time   :  2019/4/9
 * author :  Z
 * des    :
 */

class UserServiceImpl @Inject constructor() : UserService {

    @Inject
    lateinit var repository: UserRepository

    override fun register2(mobile: String, pwd: String, rePwd: String): Observable<ResponseBody> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    // 注册流程的具体实现   这里返回值是  Boolean ,
    // 但是 在真正访问文件中 的 BaseReq返回值是 String; 会用到RxJava 的 FlatMap
    override fun register(
        mobile: String, pwd: String,
        rePwd: String
    ): Observable<Boolean> {

        val repository = UserRepository()

        return Observable.just(true)


//        return repository.register(mobile, pwd, rePwd)
//            .flatMap(object : Function<BaseResp<String>, Publisher<Boolean>> {
//                override fun apply(t: BaseResp<String>): Publisher<Boolean> {
//                    if (t.status != 0) {
//                        // 表示 失败
//                        return Flowable.error(BaseException(t.status, t.message))
//                    }
//                    return Flowable.just(true)
//                }
//
//            })


//        return Flowable.just(true)
    }


}