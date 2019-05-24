package com.kotlin.WanAndroid.data.api

import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface WanAndroidAPI {


    /**
     * Banner
     */
    @GET("/banner/json")
    fun getBanner():Observable<BaseResp<List<BannerModel>>>

//    @GET("/banner/json")
//    fun getBanner2():Observable<ResponseBody>




    /**
     *  文章列表
     */
    @GET("article/list/1/json")
    fun getArticle():Observable<BaseResp<BannerModel>>



}