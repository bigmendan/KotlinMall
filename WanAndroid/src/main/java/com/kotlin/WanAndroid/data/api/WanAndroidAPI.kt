package com.kotlin.WanAndroid.data.api

import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

interface WanAndroidAPI {


    /**
     * Banner
     */
    @GET("/banner/json")
    fun getBanner(): Observable<BaseResp<List<BannerModel>>>


    /**
     *  文章列表
     */
    @GET("article/list/{page}/json")
    fun getArticle(@Path("page") page: Int): Observable<BaseResp<ArticleModel>>


}