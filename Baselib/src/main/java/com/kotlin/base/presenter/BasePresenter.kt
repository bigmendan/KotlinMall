package com.kotlin.base.presenter

import android.content.Context
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle3.LifecycleProvider
import javax.inject.Inject

/**
 *  BasePresenter 中引用 BaseView
 */
open class BasePresenter<T : BaseView> {
    // 因为不确定他的子类是什么
    lateinit var mView: T


    @Inject
    lateinit var lifecycleProvider: LifecycleProvider<*>

//    @Inject
//    lateinit var context: Context
//
//    fun checkNetWork(): Boolean {
//        return NetWorkUtils.isNetWorkAvailable(context)
//    }




}