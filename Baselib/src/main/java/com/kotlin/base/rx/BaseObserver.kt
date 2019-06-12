package com.kotlin.base.rx

import android.content.Context
import android.widget.Toast
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.utils.NetWorkUtils
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import com.kotlin.base.common.ResultCode
import com.kotlin.base.data.net.error.BaseThrowable


/**
 *  所有Observer 的基类；  不支持背压策略
 *
 */

abstract class BaseObserver<T>(private val baseView: BaseView) : Observer<BaseResp<T>> {

    private val mContext: Context = BaseApplication.context

    // 添加 Disposable  用来主动取消订阅 ;
    private lateinit var disposable: Disposable

    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
        this.disposable = d

        baseView.showLoading()

        if (!NetWorkUtils.isNetWorkAvailable()) {
            baseView.onError("网络不可用")
        }
    }

    override fun onNext(t: BaseResp<T>) {

        if (t.errorCode == ResultCode.SUCCESS) {
            onSuccess(t.data)
        } else {
            baseView.onError(t.errorMsg)
        }
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()

        /**
         *  使用自定义 类 对网络错误 解析 ;
         */
        val rx = BaseThrowable.retrofitException(e)
        baseView.onError(rx.message)

        if (disposable.isDisposed) {
            disposable.dispose()
        }
    }

    abstract fun onSuccess(t: T?)


    // 如果这里需要 对 请求失败做处理 有了再说;


}


