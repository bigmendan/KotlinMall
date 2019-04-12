package com.kotlin.base.rx

import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/12 18:08:55
 * @Des    :   观察者 ，支持背压策略 ;
 */
open abstract class BaseSubscriber<T> : Subscriber<T> {
    override fun onComplete() {
    }

    override fun onSubscribe(s: Subscription?) {
    }

    override fun onNext(result: T) {
        onSuccess(result)
    }

    override fun onError(t: Throwable?) {
        onFail(t)
    }

    abstract fun onSuccess(result: T)

    abstract fun onFail(error: Throwable?)


}