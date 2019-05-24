package com.kotlin.WanAndroid.data.repository

import com.kotlin.WanAndroid.data.api.WanAndroidAPI
import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import javax.inject.Inject

class WanAndroidRepository  @Inject  constructor() {


    /**
     *  首页轮播
     */
    fun getBanner() :Observable<BaseResp<List<BannerModel>>>{
       return service().getBanner()
    }


    /**
     *  首页获取文章列表
     */
    fun getArticle(page:Int) :Observable<BaseResp<ArticleModel>>{
        return service().getArticle(page)

    }


     private fun service(): WanAndroidAPI {
        return RetrofitFactory.instance
            .create(WanAndroidAPI::class.java)

    }
}