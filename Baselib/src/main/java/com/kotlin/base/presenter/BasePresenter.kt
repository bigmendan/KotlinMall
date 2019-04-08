package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 *  BasePresenter 中引用 BaseView
 */
open class BasePresenter<T : BaseView> {
    // 因为不确定他的子类是什么
    lateinit var mView: T
}