package com.kotlin.WanAndroid.ui.fragment


import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.ArticleData
import com.kotlin.WanAndroid.data.module.ArticleModel
import com.kotlin.WanAndroid.data.module.BannerModel
import com.kotlin.WanAndroid.injection.component.DaggerWAComponent
import com.kotlin.WanAndroid.injection.module.WAModule
import com.kotlin.WanAndroid.presenter.HomePresenter
import com.kotlin.WanAndroid.presenter.view.HomeView
import com.kotlin.WanAndroid.ui.adapter.HomeArticleAdapter
import com.kotlin.WanAndroid.utils.GlideImageLoader
import com.kotlin.base.ext.loge
import com.kotlin.base.listener.RecyclerViewScrollListener
import com.kotlin.base.ui.adapter.LoadMoreWrapper
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.base.utils.dp2px
import com.youth.banner.Banner
import kotlinx.android.synthetic.main.fragment_wan_home.*

/**
 *  首页 Fragment
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class HomeFragment : BaseMvpFragment<HomePresenter>(), HomeView, SwipeRefreshLayout.OnRefreshListener {


    private lateinit var mBanner: Banner
    private lateinit var articleAdapter: HomeArticleAdapter
    private lateinit var bannerList: MutableList<String>

    private lateinit var articleModel: ArticleModel


    private var page = 0
    private lateinit var wrapper: LoadMoreWrapper
    var allDatas = mutableListOf<ArticleData>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_wan_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
        initRecyclerView()
        mRefreshLayout.setOnRefreshListener(this)




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
        mPresenter.getArticle(page)


    }


    /*
     下拉刷新
     */
    override fun onRefresh() {
        mRefreshLayout.isRefreshing = false
        page = 0
        mPresenter.getArticle(page)

    }

    override fun bannerResult(list: List<BannerModel>) {

        bannerList = ArrayList()

        for (index in 0 until list.size) {
            var bannerModel = list[index]
            bannerList.add(bannerModel.imagePath)
        }

        initBanner(bannerList)


    }


    override fun articleResult(t: ArticleModel) {
        articleModel = t;

        if (page == 0) {
            allDatas.clear()
            allDatas = t.datas as MutableList<ArticleData>

        } else {
            allDatas.addAll(t.datas)

        }

        articleAdapter.setData(allDatas)

        // 在这里应该修改 Wrapper 的 显示状态 ;
        if (wrapper != null) {
            wrapper.setLoadState(wrapper.LOADING_COMPLETE)
        }


    }

    override fun collectionResult(b: Boolean) {
        loge("这里就是收藏成功了")
    }

    private fun initBanner(list: MutableList<String>) {

        mBanner.setImageLoader(GlideImageLoader())
        mBanner.setImages(list)
        mBanner.start()


    }


    private fun initRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        articleAdapter = HomeArticleAdapter(activity!!)

        mRecyclerView.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

        wrapper = LoadMoreWrapper(articleAdapter)

        mBanner = Banner(activity)
        var layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(240f))
        mBanner.layoutParams = layoutParams

        wrapper.addHeader(mBanner)

        mRecyclerView.adapter = wrapper

        // 点击收藏
        articleAdapter.setCollectionClickListener(object : HomeArticleAdapter.CollectionClickListener {
            override fun collection(id: Int) {
                mPresenter.setCollection(id)
            }

        })


        mRecyclerView.addOnScrollListener(object : RecyclerViewScrollListener() {
            override fun loadMore() {

                // 如果当前页数 小于 总页数 ，就是还没有加载完 ，否则 加载完成
                if (page < articleModel.pageCount) {
                    page++

                    mPresenter.getArticle(page)
                    wrapper.setLoadState(wrapper.LOADING)


                } else {

                    wrapper.setLoadState(wrapper.LOADING_END)
                }

            }

        })

    }


}
