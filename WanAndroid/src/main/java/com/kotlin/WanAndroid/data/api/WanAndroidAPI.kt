package com.kotlin.WanAndroid.data.api

import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.WanAndroid.data.module.ProjectTreeModel
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

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

    /**
     *  项目分类
     */
    @GET("project/tree/json")
    fun getProjectTree(): Observable<BaseResp<List<ProjectTreeModel>>>

    @GET("project/tree/json")
    fun getProjectTree2(): Observable<ResponseBody>

    /**
     * 项目列表数据
     */
    @GET("https://www.wanandroid.com/project/list/{page}/json?")
    fun getProjectList(@Path("page") page: Int, @Query("cid") cid: Int): Observable<BaseResp<ProjectListModel>>

}