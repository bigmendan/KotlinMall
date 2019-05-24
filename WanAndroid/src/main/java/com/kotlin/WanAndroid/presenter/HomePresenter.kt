package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.api.WanAndroidAPI
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.HomeView
import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import java.util.*
import javax.inject.Inject

/**
 *  首页 的 Presenter
 */
class HomePresenter @Inject constructor():BasePresenter<HomeView>(){


    @Inject
    lateinit var repository: WanAndroidRepository


    fun  getBanner(){
//        repository.getBanner()
//            .execute(object :BaseObserver<BannerModel>(mView){
//                override fun onSuccess(t: BannerModel?) {
//                    mView.bannerResult(t!!)
//                }
//            })

        RetrofitFactory.instance.create(WanAndroidAPI::class.java)
            .getBanner2()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(object :Observer<ResponseBody>{
                override fun onComplete() {
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(t: ResponseBody) {

                    loge("輸出 = ${t.string()}")
                }

                override fun onError(e: Throwable) {
                    loge("請求錯誤 $e")
                }

            })


    }



    fun   getArticle(){

    }



}