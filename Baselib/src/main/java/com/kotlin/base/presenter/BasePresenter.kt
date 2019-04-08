package com.kotlin.base.presenter

import com.kotlin.base.presenter.view.BaseView

/**
 *  BasePresenter 中引用 BaseView
 */
class BasePresenter<T:BaseView> {
    lateinit var mView:T
}