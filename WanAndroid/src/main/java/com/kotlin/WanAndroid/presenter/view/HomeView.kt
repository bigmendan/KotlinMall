package com.kotlin.WanAndroid.presenter.view

import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.base.presenter.view.BaseView

interface HomeView:BaseView {

    fun  bannerResult(t:BannerModel)
    fun  getArticle()

}