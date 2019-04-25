package com.kotlin.base.rx

import android.util.Log
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *  所有Observer 的基类；  不支持背压策略
 *
 */

open abstract class NormalObserver<T>(val baseView: BaseView) : Observer<BaseResp<T>> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
        baseView.showLoading()
    }

    override fun onNext(t: BaseResp<T>) {

        if (t.errorCode == 0) {
            onSuccess(t.data)
        } else {
            onFail(t.errorCode, t.errorMsg)
        }

    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()


        Log.e("===onError", "======${e.message}")
//        if (e is BaseException) {
//            Log.e("==错误", "== ${e.message}")
//
//        }

    }


    abstract fun onSuccess(t: T?)


    private fun onFail(status: Int, errorMsg: String) {

        Log.e("===", "错误 ")
    }

}


//    override fun onError(e: Throwable) {
//        LoadingDialog.cancel()
//        if (e is HttpException) {//连接服务器成功但服务器返回错误状态码
//            val apiErrorModel: ApiErrorModel = when (e.code()) {
//                ApiErrorType.INTERNAL_SERVER_ERROR.code ->
//                    ApiErrorType.INTERNAL_SERVER_ERROR.getApiErrorModel(context)
//                ApiErrorType.BAD_GATEWAY.code ->
//                    ApiErrorType.BAD_GATEWAY.getApiErrorModel(context)
//                ApiErrorType.NOT_FOUND.code ->
//                    ApiErrorType.NOT_FOUND.getApiErrorModel(context)
//                else -> otherError(e)
//            }
//            failure(e.code(), apiErrorModel)
//            return
//        }
//        val apiErrorType: ApiErrorType = when (e) {//发送网络问题或其它未知问题，请根据实际情况进行修改
//            is UnknownHostException -> ApiErrorType.NETWORK_NOT_CONNECT
//            is ConnectException -> ApiErrorType.NETWORK_NOT_CONNECT
//            is SocketTimeoutException -> ApiErrorType.CONNECTION_TIMEOUT
//            else -> ApiErrorType.UNEXPECTED_ERROR
//        }
//        failure(apiErrorType.code, apiErrorType.getApiErrorModel(context))
//    }
//
//    private fun otherError(e: HttpException) =
//        Gson().fromJson(e.response().errorBody()?.charStream(), ApiErrorModel::class.java)
