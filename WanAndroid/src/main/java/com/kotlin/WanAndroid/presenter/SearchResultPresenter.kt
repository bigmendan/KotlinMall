package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.module.SearchResultModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.SearchResultView
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import javax.inject.Inject

class SearchResultPresenter @Inject constructor() : BasePresenter<SearchResultView>() {


    @Inject
    lateinit var repository: WanAndroidRepository

    fun searchResult(page: Int, key: String) {
        repository.searchResult(page, key)
            .execute(object : BaseObserver<SearchResultModel>(mView) {
                override fun onSuccess(t: SearchResultModel?) {

                    mView.searchResult(t!!)
                }
            }

            )
    }

}