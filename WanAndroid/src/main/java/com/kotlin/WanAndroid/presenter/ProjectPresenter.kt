package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.WanAndroid.data.module.ProjectTreeModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.ProjectView
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.util.*
import javax.inject.Inject


/**
 *  ProjectPresenter
 */
class ProjectPresenter @Inject constructor() : BasePresenter<ProjectView>() {

    @Inject
    lateinit var reponsitory: WanAndroidRepository

    fun getProjectTree() {


        reponsitory.getProjectTree()
            .execute(object : BaseObserver<List<ProjectTreeModel>>(mView) {
                override fun onSuccess(t: List<ProjectTreeModel>?) {
                    mView.projectTreeResult(t!!)

                }


            })
    }


}