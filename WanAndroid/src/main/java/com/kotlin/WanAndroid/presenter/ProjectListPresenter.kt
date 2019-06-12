package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.ProjectsView
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import javax.inject.Inject

/**
 *  项目类别下的 FragmentPresenter
 */
class ProjectListPresenter @Inject constructor() : BasePresenter<ProjectsView>() {


    @Inject
    lateinit var repository: WanAndroidRepository

    fun getProjectList(page: Int, cid: Int) {

        repository.getProjectList(page, cid)
            .execute(object : BaseObserver<ProjectListModel>(mView) {
                override fun onSuccess(t: ProjectListModel?) {
                    mView.projectListResult(t!!)
                }

            })

    }


}