package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.HomeView
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import okhttp3.ResponseBody
import javax.inject.Inject

/**
 *  首页 的 Presenter
 */
class HomePresenter @Inject constructor() : BasePresenter<HomeView>() {


    @Inject
    lateinit var repository: WanAndroidRepository


    fun getBanner() {
        repository.getBanner()
            .execute(object : BaseObserver<List<BannerModel>>(mView) {
                override fun onSuccess(list: List<BannerModel>?) {
                    mView.bannerResult(list!!)
                }

            })


    }


    fun getArticle(page: Int) {
        repository.getArticle(page)
            .execute(object : BaseObserver<ArticleModel>(mView) {
                override fun onSuccess(t: ArticleModel?) {
                    mView.articleResult(t!!)
                }

            })


    }

    fun setCollection(cid: Int) {
        repository.setCollection(cid)
            .execute(object : Observer<ResponseBody> {
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: ResponseBody) {
                    mView.collectionResult(true)
                }

                override fun onError(e: Throwable) {
                }
            })


    }


}