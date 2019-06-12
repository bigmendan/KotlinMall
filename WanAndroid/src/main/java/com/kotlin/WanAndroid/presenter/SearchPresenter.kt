package com.kotlin.WanAndroid.presenter

import com.kotlin.WanAndroid.data.module.HotSearchModel
import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import com.kotlin.WanAndroid.presenter.view.SearchView
import com.kotlin.base.data.protocol.BaseResp
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.presenter.BasePresenter
import com.kotlin.base.rx.BaseObserver
import javax.inject.Inject

/**
 *  Search 的Presenter
 */
class SearchPresenter @Inject constructor() : BasePresenter<SearchView>() {


    @Inject
    lateinit var repository: WanAndroidRepository

    fun hotSearch() {
        repository.hotSearch()
            .execute(object : BaseObserver<List<HotSearchModel>>(mView) {
                override fun onSuccess(t: List<HotSearchModel>?) {
                    mView.hotSearchResult(t!!)
                }

            })
    }
}