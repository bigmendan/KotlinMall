package com.kotlin.UserCenter.presenter

import android.util.Log
import android.widget.Toast
import com.kotlin.UserCenter.data.api.UserApi
import com.kotlin.UserCenter.data.protocol.Register2Req
import com.kotlin.UserCenter.data.respository.UserRepository
import com.kotlin.UserCenter.presenter.view.LoginView
import com.kotlin.UserCenter.ui.service.UserService
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.rx.BaseObserver
import okhttp3.ResponseBody
import javax.security.auth.login.LoginException

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/12 12:17:11
 * @Des    :   处理 Login  的登录 业务逻辑
 */
class Register2Presenter : BasePresenter<LoginView>() {


    fun register2(mobile: String, pwd: String, rePwd: String) {

        // 直接在这里调用Retrofit 网络请求 ;
//        val repository = UserRepository()
//        repository.register2(mobile, pwd, rePwd)
//            .execute(object : BaseObserver<BaseResp<String>>() {
//                override fun onNext(t: BaseResp<String>) {
//                    Log.e("===", "成功 = ${t.status} ")
//                    mView.login(true)
//                }
//
//                override fun onError(e: Throwable) {
//                    Log.e("===", "失败  = ${e.message} ")
//                }
//
//            })


        RetrofitFactory.instance
            .create(UserApi::class.java)
            .register2(Register2Req(mobile, pwd, rePwd))
            .execute(object : BaseObserver<ResponseBody>() {
                override fun onNext(t: ResponseBody) {
                    var string = t.string()
                    Log.e("==", "t = ${string}")

                }

                override fun onError(e: Throwable) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

            })


    }

}