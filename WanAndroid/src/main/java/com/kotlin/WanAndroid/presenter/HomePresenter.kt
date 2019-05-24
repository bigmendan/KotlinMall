package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.HomeView
import com.kotlin.base.ext.execute
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import javax.inject.Inject

/**
 *  首页 的 Presenter
 */
class HomePresenter @Inject constructor():BasePresenter<HomeView>(){


    @Inject
    lateinit var repository: WanAndroidRepository


    fun  getBanner(){
        repository.getBanner()
            .execute(object :BaseObserver<List<BannerModel>>(mView){
                override fun onSuccess(list: List<BannerModel>?) {
                    mView.bannerResult(list!!)
                }

            })



    }



    fun   getArticle(){

    }



}