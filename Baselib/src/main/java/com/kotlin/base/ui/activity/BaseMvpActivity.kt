package com.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.module.LifecycleProviderModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import dagger.Module
import javax.inject.Inject


/**
 * 继承BaseMvpActivity 中需要引用BasePresenter,用个*
 */
 abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {


    // 其子类中需要传入的presenter 不确定，所以传入一个泛型
    @Inject
    lateinit var mPresenter: T


    private lateinit var mLoadingDialog: ProgressLoading


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLoadingDialog = ProgressLoading.create(this)

        initActivityInjection()

        injectionComponent()
    }

    lateinit var activityComponent: ActivityComponent

    private fun initActivityInjection() {
        activityComponent =
            DaggerActivityComponent.builder()
                .appComponent((application as BaseApplication).appComponent)
                .activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))    // 因为 RxAppCompatActivity 实现了 LifecycleProvider 接口 ;
                .build()


    }

    abstract fun injectionComponent()


    override fun showLoading() {

        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.hideLoading()
    }

    override fun onError() {
        mLoadingDialog.hideLoading()
    }


}