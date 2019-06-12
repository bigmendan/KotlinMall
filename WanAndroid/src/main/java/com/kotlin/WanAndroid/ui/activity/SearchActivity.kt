package com.kotlin.WanAndroid.ui.activity

import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.data.module.HotSearchModel
import com.kotlin.WanAndroid.injection.component.DaggerWAComponent
import com.kotlin.WanAndroid.injection.module.WAModule
import com.kotlin.WanAndroid.presenter.SearchPresenter
import com.kotlin.WanAndroid.presenter.view.SearchView
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.zhy.view.flowlayout.TagAdapter
import kotlinx.android.synthetic.main.activity_search.*
import android.widget.TextView
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.kotlin.WanAndroid.ui.adapter.SearchHistoryAdapter
import com.kotlin.WanAndroid.utils.HistoryUtil
import com.kotlin.base.ext.execute
import com.kotlin.base.ext.loge
import com.kotlin.base.ext.onClick
import com.kotlin.base.rx.NormalObserver
import com.kotlin.base.utils.StatusBarUtils
import com.zhy.view.flowlayout.FlowLayout
import com.zhy.view.flowlayout.TagFlowLayout
import io.reactivex.Observable
import org.jetbrains.anko.startActivity


/**
 * 搜索
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class SearchActivity : BaseMvpActivity<SearchPresenter>(), SearchView, View.OnClickListener {


    lateinit var historyAdapter: SearchHistoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        StatusBarUtils.darkMode(this)
        StatusBarUtils.setPaddingSmart(this, mToolBar)

        mBackIv.onClick(this)
        mClearTv.onClick(this)
        mSearchIv.onClick(this)

        loadData()
        initRecyclerView()

    }


    // 热门搜索
    private fun loadData() {
        mPresenter.hotSearch()

//         通过 SharedPreferences
//        var history = HistoryUtil.getHistory()

    }

    private fun search() {
        // 在这里直接跳转到 下一页 去执行 搜索;
        var searchStr = mSearchEt.text.toString()

        if (!TextUtils.isEmpty(searchStr)) {
            startActivity<SearchResultActivity>("key" to searchStr)
        }


    }

    override fun injectionComponent() {
        DaggerWAComponent.builder()
            .activityComponent(activityComponent)
            .wAModule(WAModule())
            .build()
            .inject(this)

        mPresenter.mView = this


    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.mBackIv -> onBackPressed()
            R.id.mClearTv -> {
                // "清空搜索记录"
            }
            R.id.mSearchIv -> {
                search()
            }
        }
    }

    override fun hotSearchResult(t: List<HotSearchModel>) {

        var inflater = LayoutInflater.from(this)

        mFlowLayout.adapter = object : TagAdapter<HotSearchModel>(t) {
            override fun getView(parent: FlowLayout?, position: Int, t: HotSearchModel?): View {
                var tv = inflater.inflate(R.layout.flowlayout_tv, mFlowLayout, false) as TextView
                tv.text = t!!.name
                return tv

            }
        }



        mFlowLayout.setOnTagClickListener(object : TagFlowLayout.OnTagClickListener {
            override fun onTagClick(view: View?, position: Int, parent: FlowLayout?): Boolean {
                var hotSearchModel = t[position]

                startActivity<SearchResultActivity>("key" to hotSearchModel.name)
                return true
            }
        })


    }

    private fun initRecyclerView() {
        mHistoryRecyclerView.layoutManager = LinearLayoutManager(this)
        historyAdapter = SearchHistoryAdapter(this)


        mHistoryRecyclerView.adapter = SearchHistoryAdapter(this)


    }


}
