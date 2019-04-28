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

    @Inject
    lateinit var context: Context

    /**
     *   检查网络 是否可用 ;
     */
    fun checkNetWork(): Boolean {
        return if (NetWorkUtils.isNetWorkAvailable(context)) {

            true
        } else {
            mView.onError("网络不可用")
            false
        }
    }


}