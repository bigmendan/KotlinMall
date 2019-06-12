package com.kotlin.WanAndroid.presenter.view

import com.kotlin.WanAndroid.data.module.HotSearchModel
import com.kotlin.base.presenter.view.BaseView

/**
 *  搜索 的 View
 */
interface SearchView : BaseView {


    fun hotSearchResult(t: List<HotSearchModel>);

}