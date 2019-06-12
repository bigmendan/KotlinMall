package com.kotlin.WanAndroid.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.ListData
import com.kotlin.WanAndroid.data.module.SearchResultData
import com.kotlin.WanAndroid.data.module.SearchResultModel
import com.kotlin.WanAndroid.injection.component.DaggerWAComponent
import com.kotlin.WanAndroid.injection.module.WAModule
import com.kotlin.WanAndroid.presenter.SearchResultPresenter
import com.kotlin.WanAndroid.presenter.view.SearchResultView
import com.kotlin.WanAndroid.ui.adapter.SearchResultAdapter
import com.kotlin.WanAndroid.utils.HistoryUtil
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.ext.onClick
import com.kotlin.base.listener.RecyclerViewScrollListener
import com.kotlin.base.rx.NormalObserver
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.base.ui.adapter.LoadMoreWrapper
import com.kotlin.base.utils.StatusBarUtils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_search_result.*
import org.reactivestreams.Subscriber

/**
 *  搜索结果页;
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class SearchResultActivity : BaseMvpActivity<SearchResultPresenter>(), SearchResultView,
    SwipeRefreshLayout.OnRefreshListener {


    var key = ""
    var page = 0
    var pageCount = 0
    lateinit var searchResultAdapter: SearchResultAdapter
    lateinit var wrapper: LoadMoreWrapper
    private var allDatas = mutableListOf<SearchResultData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)


        StatusBarUtils.darkMode(this)
        StatusBarUtils.setPaddingSmart(this, mToolBar)

        key = intent.getStringExtra("key")
        mTitleTv.text = key

        mRefreshLayout.setOnRefreshListener(this)
        initRecyclerView()
        mBackIv.onClick { onBackPressed() }

        loadData(page, key)

    }

    override fun injectionComponent() {
        DaggerWAComponent.builder()
            .wAModule(WAModule())
            .activityComponent(activityComponent)
            .build()
            .inject(this)
        mPresenter.mView = this
    }

    /*
         搜索成功的返回 结果
     */
    override fun searchResult(t: SearchResultModel) {


        pageCount = t.pageCount

        if (page == 0) {
            allDatas.clear()
            allDatas = t.datas as MutableList<SearchResultData>

        } else {
            allDatas.addAll(t.datas)
        }
        searchResultAdapter.setData(allDatas)

        if (wrapper != null) {
            wrapper.setLoadState(wrapper.LOADING_COMPLETE)
        }


//        HistoryUtil.putHistory(key)


    }

    override fun onRefresh() {
        page = 0
        mRefreshLayout.isRefreshing = false

        loadData(page, key)

    }

    fun loadData(page: Int, key: String) {
        mPresenter.searchResult(page, key)

    }

    private fun initRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(this)

        mRecyclerView.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        searchResultAdapter = SearchResultAdapter(this)

        wrapper = LoadMoreWrapper(searchResultAdapter)

        mRecyclerView.adapter = wrapper


        mRecyclerView.addOnScrollListener(object : RecyclerViewScrollListener() {
            override fun loadMore() {
                if (page <= pageCount) {
                    loadData(page, key)
                    wrapper.setLoadState(wrapper.LOADING)
                    page++
                } else {
                    wrapper.setLoadState(wrapper.LOADING_END)
                }
            }

        })


    }
}
