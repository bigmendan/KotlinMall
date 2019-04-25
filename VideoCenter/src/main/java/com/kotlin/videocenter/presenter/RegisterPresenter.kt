package com.kotlin.videocenter.presenter

import android.util.Log
import com.kotlin.videocenter.data.VideoApi
import com.kotlin.videocenter.presenter.view.RegisterView
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/18 15:18:04
 * @Des    :
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {


    // 在这里执行 register  的业务逻辑
    fun register(username: String, password: String, repassword: String) {

        mView.showLoading()

        RetrofitFactory.instance.create(VideoApi::class.java)
            .register(username, password, repassword)
            .execute(object : BaseObserver<ResponseBody>(mView) {
                override fun onNext(t: ResponseBody) {

                    Log.e("==", "返回结果 = ${t.string()}")
                    mView.registerResult(true)
                }

                override fun onError(e: Throwable) {
                    Log.e("==", "返回错误 = ${e.message}")
                    mView.hideLoading()
                }

            }, lifecycleProvider)

    }


}