package com.kotlin.base.ui.activity

import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import dagger.Module
import javax.inject.Inject


/**
 * 继承BaseMvpActivity 中需要引用BasePresenter,用个*
 */
open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {
    override fun showLoading() {

    }

    override fun hideLoading() {

    }

    override fun onError() {

    }

    // 其子类中需要传入的presenter 不确定，所以传入一个泛型
    @Inject
    lateinit var mPresenter: T


}