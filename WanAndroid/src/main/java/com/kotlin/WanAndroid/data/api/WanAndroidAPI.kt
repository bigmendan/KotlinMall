package com.kotlin.WanAndroid.data.api

import com.kotlin.WanAndroid.data.module.*
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.*

interface WanAndroidAPI {


    /**
     * Banner
     */
    @GET("/banner/json")
    fun getBanner(): Observable<BaseResp<List<BannerModel>>>


    /**
     *  首页文章列表
     */
    @GET("article/list/{page}/json")
    fun getArticle(@Path("page") page: Int): Observable<BaseResp<ArticleModel>>


    /**
     *  收藏站内文章
     */
    @POST("lg/collect/{cid}/json")
    fun collectionArticle(@Path("cid") cid: Int): Observable<ResponseBody>

    /**
     *  项目分类
     */
    @GET("project/tree/json")
    fun getProjectTree(): Observable<BaseResp<List<ProjectTreeModel>>>


    /**
     * 项目列表数据
     */
    @GET("project/list/{page}/json?")
    fun getProjectList(@Path("page") page: Int, @Query("cid") cid: Int): Observable<BaseResp<ProjectListModel>>


    /**
     *  体系
     */
    @GET("tree/json")
    fun getSystemTree(): Observable<BaseResp<List<SystemTreeModel>>>

    /**
     *  热门搜索
     */
    @GET("hotkey/json")
    fun hotSearch(): Observable<BaseResp<List<HotSearchModel>>>


    /**
     *  搜索
     */
    @FormUrlEncoded
    @POST("article/query/{page}/json")
    fun searchResult(@Path("page") page: Int, @Field("k") k: String): Observable<BaseResp<SearchResultModel>>


}