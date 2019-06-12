package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.api.WanAndroidAPI
import com.kotlin.WanAndroid.data.module.SystemTreeModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.SystemView
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import com.kotlin.provider.router.RouterPath
import javax.inject.Inject

/**
 *  体系 Presenter
 */
class SystemPresenter @Inject constructor() : BasePresenter<SystemView>() {

    @Inject
    lateinit var repository: WanAndroidRepository

    fun getSystemTree() {
        loge("请求体系 列表 = ")
        repository.getSystemTree()
            .execute(object : BaseObserver<List<SystemTreeModel>>(mView) {
                override fun onSuccess(t: List<SystemTreeModel>?) {
                    mView.getSystemTree(t!!)
                }


            })

    }
}
