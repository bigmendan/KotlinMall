package com.kotlin.base.ext

import android.util.Log
import com.kotlin.base.rx.BaseObserver
import com.kotlin.base.rx.BaseSubscriber
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription


/**
 * 封装所有 Observable.subscribe(Observer)重复过程;
 */
fun <T> Observable<T>.execute(observer: BaseObserver<T>) {

    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(observer)

}


// 支持背压的 链式 ;
fun <T> Flowable<T>.execute(subscriber: BaseSubscriber<T>) {

    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(subscriber)
}