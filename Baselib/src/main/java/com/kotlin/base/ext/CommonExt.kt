package com.kotlin.base.ext

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.rx.BaseSubscriber
import com.kotlin.base.rx.BaseObserver
import com.kotlin.base.widgets.DefaultWatcher
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 *  不确定数据类型
 */
fun <T> Observable<T>.execute(observer: Observer<T>) {

    this.observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(observer)

}

/**
 *  不添加生命周期
 */
fun <T> Observable<BaseResp<T>>.execute(observer: BaseObserver<T>) {

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

/**
 *  Button 扩展 ，根据 EditText 和 传入对EditText的相应判断，来判断按钮是否可用
 */
fun Button.enable(et: EditText, method: () -> Boolean) {
    val btn = this
    et.addTextChangedListener(object : DefaultWatcher() {

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            // btn 是否可用 ，取决于 第二个参数传入的方法的返回值;
            // 这个方法又需要在外面定义
            // 这里为什么是用一个方法,而不是用一个 变量
            btn.isEnabled = method()

        }
    })
}



const val TAG = "== test"

fun logv(msg: String) {
    Log.v(TAG, msg)
}

fun logd(msg: String) {
    Log.d(TAG, msg)
}

fun logi(msg: String) {
    Log.i(TAG, msg)
}

fun logw(msg: String) {
    Log.w(TAG, msg)
}

fun logw(tr: Throwable) {
    Log.w(TAG, tr)
}

fun logw(msg: String, tr: Throwable) {
    Log.w(TAG, msg, tr)
}

fun loge(msg: String) {
    Log.e(TAG, msg)
}

fun loge(msg: String, tr: Throwable) {
    Log.e(TAG, msg, tr)
}

