package com.kotlin.base.ext

import android.util.Log
import com.kotlin.base.rx.BaseObserver
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


/**
 * 封装所有 Observable.subscribe(Observer)重复过程;
 */
fun <T> Observable<T>.execute(observer: BaseObserver<T>) {

    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(observer)

}