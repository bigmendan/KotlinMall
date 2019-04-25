package com.kotlin.UserCenter.presenter

import android.util.Log
import com.kotlin.UserCenter.data.api.UserApi
import com.kotlin.UserCenter.data.module.UserRegisterModel
import com.kotlin.UserCenter.data.respository.UserRepository
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.execute2
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseException
import com.kotlin.base.rx.BaseObserver
import com.kotlin.base.rx.NormalObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import javax.inject.Inject


/**
 * time   :  2019/4/8
 * author :  Z
 * des    :  引入dagger 添加 @Inject 注解 ;
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {


    @Inject
    lateinit var repository: UserRepository

    fun register(username: String, password: String, repassword: String) {
        // 网络请求之前先开启弹窗
        mView.showLoading()

        repository.register(username, password, repassword)
            .execute(object : BaseObserver<ResponseBody>(mView) {

                override fun onNext(t: ResponseBody) {
                    super.onNext(t)
                    Log.e("===", "${t.string()}")


                }

                override fun onError(e: Throwable) {
                    super.onError(e)
//                    Log.e("===", "${e.message}")

                }
            }, lifecycleProvider)

    }


    // 封装了响应体
    fun register2(username: String, password: String, repassword: String) {
        mView.showLoading()


//        repository.register2(username, password, repassword)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(object : BaseObserver<ResponseBody>(mView) {
//
//                override fun onNext(t: ResponseBody) {
//                    super.onNext(t)
//                    Log.e("===", "${t.string()}")
//                }
//
//                override fun onError(e: Throwable) {
//                    super.onError(e)
//                    Log.e("===", "${e.message}")
//                }
//            })


        repository.register2(username, password, repassword)
            .execute2(object : NormalObserver<UserRegisterModel>(mView) {
                override fun onSuccess(t: UserRegisterModel?) {

                    Log.e("===onSuccess", "返回 $t")
                }

            }, lifecycleProvider)


    }


}



