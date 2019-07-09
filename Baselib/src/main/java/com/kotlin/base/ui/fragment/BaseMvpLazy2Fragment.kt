package com.kotlin.base.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.ext.loge
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import javax.inject.Inject


/**
 * 继承BaseMvpActivity 中需要引用BasePresenter,用个*   数据懒加载
 *
 *   目前这个功能比较完整 ，可以判断数据是否加载过，
 *   需要在 Activity 中添加 viewPager.offscreenPageLimit = *
 */
open abstract class BaseMvpLazy2Fragment<T : BasePresenter<*>> : BaseFragment(), BaseView {


    private val TAG = "== FRAGMENT ="
    // 其子类中需要传入的presenter 不确定，所以传入一个泛型
    @Inject
    lateinit var mPresenter: T

    private lateinit var mLoadingDialog: ProgressLoading
    lateinit var activityComponent: ActivityComponent

    protected var rootView: View? = null


    // Fragment 的View 加载完毕的标记
    private var isViewCreated: Boolean = false

    /*
        数据是否加载过了
     */
    private var hasLoadData = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loge("执行 onCreate() ")

        initActivityInjection()

        injectionComponent()
        mLoadingDialog = ProgressLoading.create(activity!!)
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


    /**
     * 初始化时该方法会调用两次，并且在 onAttach() 之前
     */
    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)

        loge("执行setUserVisibleHint() = $isVisibleToUser")
        if (isVisibleToUser) {
            lazyLoadDataIfPrepared()
        }


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loge("执行  onViewCreated =")


        isViewCreated = true
        initView()
        lazyLoadDataIfPrepared()
    }


    /**
     *  懒加载 是在用户可见，并且 Xml已经渲染完成  && 数据已经加载过 的情况下 再去读取数据;
     */
    private fun lazyLoadDataIfPrepared() {

        loge("用户是否可见 = $userVisibleHint ，数据是否加载完成 = $isViewCreated , 数据是否加载过 $hasLoadData")
        if (userVisibleHint && isViewCreated && !hasLoadData) {
            lazyLoad()
            hasLoadData = true
        } else {
            loge("不需要重复加载数据 ，但是前面数据已经没有了")
        }


    }

    /*
      加载 布局
     */
    abstract fun getLayoutId(): Int

    /*
       初始化 View
     */
    abstract fun initView()



    /*
      懒加载
     */
    abstract fun lazyLoad()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loge("  onActivityCreated() ,, isViewCreated  = $isViewCreated ")

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        loge(" onCreateView ()")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        loge(" onStart ()")
    }

    override fun onResume() {
        super.onResume()
        loge(" onResume ()")


    }

    override fun onPause() {
        super.onPause()
        loge(" onPause ()")
    }

    override fun onStop() {
        super.onStop()
        loge(" onStop ()")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        loge(" onDestroy ()")
        isViewCreated = false;
    }

}