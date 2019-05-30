package com.kotlin.WanAndroid.data.repository

import com.kotlin.WanAndroid.data.api.WanAndroidAPI
import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.WanAndroid.data.module.ProjectTreeModel
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
     *   项目分类
     */
    fun getProjectTree(): Observable<BaseResp<List<ProjectTreeModel>>> {
        return service().getProjectTree()
    }

    fun  getProjectTree2():Observable<ResponseBody>{
        return  service().getProjectTree2()
    }


    /**
     *  项目列表详情；
     */
    fun getProjectList(page: Int, cid: Int): Observable<BaseResp<ProjectListModel>> {
        return service().getProjectList(page, cid)
    }




    private fun service(): WanAndroidAPI {
        return RetrofitFactory.instance
            .create(WanAndroidAPI::class.java)

    }


}