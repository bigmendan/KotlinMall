package com.kotlin.base.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.common.BaseApplication
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.component.DaggerActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.widgets.ProgressLoading
import javax.inject.Inject


/**
 * 继承BaseMvpActivity 中需要引用BasePresenter,用个*   数据懒加载
 */
open abstract class BaseMvpLazyFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {


    private val TAG = "== FRAGMENT ="
    // 其子类中需要传入的presenter 不确定，所以传入一个泛型
    @Inject
    lateinit var mPresenter: T

    private lateinit var mLoadingDialog: ProgressLoading
    lateinit var activityComponent: ActivityComponent
    protected var rootView: View? = null


    // Fragment 的View 加载完毕的标记
    private var isViewCreated: Boolean = false

    // Fragment 对用户可见的标记
    private var isVisibleToUser: Boolean = false

    //数据是否初始化  避免重复加载数据
//    private var isDataInitiated = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

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

//        Log.e(TAG, "对用户是否可见: $isVisibleToUser")
        this.isVisibleToUser = isVisibleToUser
        prepareFetchData()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        Log.e(TAG, "onCreateView: ")
        rootView = inflater.inflate(getContentView(), container, false)
//        initView()
        return rootView
    }

    protected abstract fun getContentView(): Int

//    protected abstract fun initView()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        Log.d(TAG, "onActivityCreated: ")
        isViewCreated = true
        prepareFetchData()
    }

    /**
     * 准备加载数据，只有在视图初始化完毕，Fragment 可见且数据未初始化的时候才去加载数据。
     * */
    private fun prepareFetchData() {
//        Log.e(
//            TAG, "准备加载数据: " +
//                    "View是否创建完 = $isViewCreated, " +
//                    "对用户可见 = $isVisibleToUser, " /*+
//                    "数据初始化 = $isDataInitiated"*/
//        )
        if (isViewCreated && isVisibleToUser /*&& !isDataInitiated*/) {
//            isDataInitiated = true
            fetchData()
        }
    }

    /**
     * 在该方法中通过发起网络请求等操作获取数据
     */
    abstract fun fetchData()

    override fun onStart() {
        super.onStart()
//        Log.e(TAG, "onStart: ")
    }

    override fun onResume() {
        super.onResume()
//        Log.e(TAG, "onResume: ")
    }

    override fun onStop() {
        super.onStop()
//        Log.e(TAG, "onStop: ")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // 如果需要在每次视图重建的时候都重新获取数据的话，在这里把 isViewInitiated 改为 false 就可以了
        isViewCreated = false
//        Log.e(TAG, "onDestroyView: ")
    }

    override fun onDestroy() {
        super.onDestroy()
        // 如果使用的是 FragmentPagerAdapter 不会每次都调用 onDestroy()，fragment 实例会被保存
        // 但是 FragmentStatePagerAdapter 会同时调用 onDestroyView() 和 onDestroy()，仅保存 fragment 的 state
//        isDataInitiated = false
//        Log.e(TAG, "onDestroy: ")
    }

    override fun onDetach() {
        super.onDetach()
//        Log.e(TAG, "onDetach: ")
    }
}