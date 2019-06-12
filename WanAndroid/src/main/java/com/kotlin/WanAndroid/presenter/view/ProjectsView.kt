package com.kotlin.WanAndroid.presenter.view

import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.base.presenter.view.BaseView

interface ProjectsView : BaseView {



    fun projectListResult(t: ProjectListModel)

}