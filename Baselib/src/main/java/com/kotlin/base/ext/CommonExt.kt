package com.kotlin.base.ext

import android.util.Log
import android.view.OrientationEventListener
import android.view.View
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseObserver
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.rx.NormalObserver
import com.trello.rxlifecycle3.LifecycleProvider
import com.trello.rxlifecycle3.kotlin.bindToLifecycle
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


fun <T> Observable<BaseResp<T>>.execute(observer: NormalObserver<T>, lifecycleProvider: LifecycleProvider<*>) {

    this.observeOn(AndroidSchedulers.mainThread())
        .compose(lifecycleProvider.bindToLifecycle())     // 添加 RxLifecycle  管理生命周期 ;
        .subscribeOn(Schedulers.io())
        .subscribe(observer)

}


// 支持背压的 链式 ;
fun <T> Flowable<T>.execute(subscriber: BaseSubscriber<T>) {
    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(subscriber)
}


fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

/*
    扩展点击事件，参数为方法
 */
fun View.onClick(method: () -> Unit): View {
    setOnClickListener { method() }
    return this
}

