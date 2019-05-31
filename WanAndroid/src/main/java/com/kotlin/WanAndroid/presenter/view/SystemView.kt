package com.kotlin.WanAndroid.presenter.view

import com.kotlin.WanAndroid.data.module.SystemTreeModel
import com.kotlin.base.presenter.view.BaseView

interface SystemView : BaseView {


    fun getSystemTree(list:List<SystemTreeModel>)
}