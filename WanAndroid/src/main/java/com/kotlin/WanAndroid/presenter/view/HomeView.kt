package com.kotlin.WanAndroid.presenter.view

import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.base.presenter.view.BaseView

interface HomeView : BaseView {

    fun bannerResult(list: List<BannerModel>)
    fun articleResult(t: ArticleModel)

    fun collectionResult(b: Boolean)

}