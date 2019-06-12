package com.kotlin.WanAndroid.data.repository

import com.kotlin.WanAndroid.data.api.WanAndroidAPI
import com.kotlin.WanAndroid.data.module.*
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
import javax.inject.Inject

class WanAndroidRepository @Inject constructor() {


    /**
     *  首页轮播
     */
    fun getBanner(): Observable<BaseResp<List<BannerModel>>> {
        return service().getBanner()
    }


    /**
     *  首页获取文章列表
     */
    fun getArticle(page: Int): Observable<BaseResp<ArticleModel>> {
        return service().getArticle(page)

    }

    /**
     *  收藏文章
     */
    fun setCollection(cid: Int): Observable<ResponseBody> {
        return service().collectionArticle(cid)
    }

    /**
     *   项目分类
     */
    fun getProjectTree(): Observable<BaseResp<List<ProjectTreeModel>>> {
        return service().getProjectTree()
    }


    /**
     *  项目列表详情；
     */
    fun getProjectList(page: Int, cid: Int): Observable<BaseResp<ProjectListModel>> {
        return service().getProjectList(page, cid)
    }


    /**
     *  体系
     */
    fun getSystemTree(): Observable<BaseResp<List<SystemTreeModel>>> {
        return service().getSystemTree()

    }


    /**
     *  热门搜索
     */
    fun hotSearch(): Observable<BaseResp<List<HotSearchModel>>> {
        return service().hotSearch()
    }

    /**
     *  通过关键字搜索;
     */
    fun searchResult(page: Int, key: String): Observable<BaseResp<SearchResultModel>> {
        return service().searchResult(page, key)
    }

    private fun service(): WanAndroidAPI {
        return RetrofitFactory.instance
            .create(WanAndroidAPI::class.java)

    }


}