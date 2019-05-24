package com.kotlin.WanAndroid.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.WanAndroid.injection.component.DaggerWAComponent
import com.kotlin.WanAndroid.injection.module.WAModule
import com.kotlin.WanAndroid.presenter.HomePresenter
import com.kotlin.WanAndroid.presenter.view.HomeView
import com.kotlin.WanAndroid.utils.GlideImageLoader
import com.kotlin.base.ext.loge
import com.kotlin.base.ui.fragment.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_wan_home.*

/**
 *  首页 Fragment
 */
class HomeFragment : BaseMvpFragment<HomePresenter>(), HomeView {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_wan_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()

    }

    override fun injectionComponent() {

        DaggerWAComponent.builder()
            .activityComponent(activityComponent)
            .wAModule(WAModule())
            .build()
            .inject(this)

        mPresenter.mView = this
    }


    private fun loadData() {
        mPresenter.getBanner()
        mPresenter.getArticle(0)
    }


    override fun bannerResult(list: List<BannerModel>) {


        var bannerList: MutableList<String> = ArrayList()

        for (index in 0..list.size) {
            var bannerModel = list[index]
            bannerList.add(bannerModel.url)
        }
        initBanner(bannerList)


    }


    override fun articleResult(t: ArticleModel) {
        loge("获取文章列表 $t")
    }


    private fun initBanner(list: MutableList<String>) {
        mBanner.setImageLoader(GlideImageLoader())
        mBanner.setImages(list)
        mBanner.start()
    }

}
