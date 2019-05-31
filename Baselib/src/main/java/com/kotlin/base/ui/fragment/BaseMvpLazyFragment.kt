package com.kotlin.base.ui.fragment

import android.os.Bundle
import android.view.View
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import javax.inject.Inject


/**
 * 继承BaseMvpActivity 中需要引用BasePresenter,用个*
 */
open abstract class BaseMvpLazyFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {


    // 其子类中需要传入的presenter 不确定，所以传入一个泛型
    @Inject
    lateinit var mPresenter: T

    private lateinit var mLoadingDialog: ProgressLoading
    lateinit var activityComponent: ActivityComponent


    // Fragment 的View 加载完毕的标记
    private var isViewCreated: Boolean = false

    // Fragment 对用户可见的标记
    private var isUIVisible: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initActivityInjection()

        injectionComponent()
        mLoadingDialog = ProgressLoading.create(activity!!)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        isViewCreated = true
    }


    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isUIVisible = true
            lazyLoad()
        } else {
            isUIVisible = false
        }
    }

    private fun lazyLoad() {
        if (isViewCreated && isUIVisible) {

            initDatas()
            isViewCreated = false
            isUIVisible = false
        }
    }

    abstract fun initDatas()

    override fun onDestroyView() {
        super.onDestroyView()
        isViewCreated = false
        isUIVisible = false
    }

    private fun initActivityInjection() {
        activityComponent =
            DaggerActivityComponent.builder()
                .appComponent((activity!!.application as BaseApplication).appComponent)
                .activityModule(ActivityModule(activity!!))
                .build()

    }

    abstract fun injectionComponent()

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError(msg: String) {

    }


}