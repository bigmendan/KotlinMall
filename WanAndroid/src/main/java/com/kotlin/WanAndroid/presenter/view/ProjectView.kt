package com.kotlin.WanAndroid.presenter.view

import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.WanAndroid.data.module.ProjectTreeModel
import com.kotlin.base.presenter.view.BaseView

interface ProjectView : BaseView {

    fun projectTreeResult(t: List<ProjectTreeModel>)



}