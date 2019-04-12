package com.kotlin.base.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 *  所有Observer 的基类；  不支持背压策略
 *
 */

abstract class BaseObserver<T> : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }


}