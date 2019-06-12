package com.kotlin.WanAndroid.presenter.view

import com.kotlin.WanAndroid.data.module.SearchResultModel
import com.kotlin.base.presenter.view.BaseView

interface SearchResultView : BaseView {

    fun searchResult(t: SearchResultModel)

}