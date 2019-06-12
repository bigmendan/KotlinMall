package com.kotlin.base.rx

import io.reactivex.Observer
import io.reactivex.disposables.Disposable


/**
 *  简化一下 Observer
 */
abstract class NormalObserver<T> : Observer<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onNext(t: T) {
        success(t)
    }

    override fun onError(e: Throwable) {
    }


    abstract fun success(t: T)


}