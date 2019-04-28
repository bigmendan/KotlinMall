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
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
        baseView.showLoading()

        if (!NetWorkUtils.isNetWorkAvailable()) {
            baseView.onError("网络不可用")
        }
    }

    override fun onNext(t: BaseResp<T>) {

        if (t.errorCode == ResultCode.SUCCESS) {
            onSuccess(t.data)
        } else {
            Toast.makeText(mContext, t.errorMsg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onError(e: Throwable) {
        baseView.hideLoading()

        val rx = BaseThrowable.retrofitException(e)
        Toast.makeText(BaseApplication.context, rx.message, Toast.LENGTH_SHORT).show()
    }

    abstract fun onSuccess(t: T?)


    // 如果这里需要 对 请求失败做处理 有了再说;

}


