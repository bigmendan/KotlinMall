package com.kotlin.base.rx

import com.kotlin.base.presenter.view.BaseView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *  所有Observer 的基类；  不支持背压策略
 *
 */

open abstract class BaseObserver<T>(val baseView: BaseView) : Observer<T> {
    override fun onComplete() {
        baseView.hideLoading()
    }

    override fun onSubscribe(d: Disposable) {
        baseView.showLoading()
    }

    override fun onNext(t: T) {

    }

    // 在error 里面把异常都处理了
    override fun onError(e: Throwable) {
        baseView.hideLoading()

        if (e is BaseException) {

        }
    }


}



