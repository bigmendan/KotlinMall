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

import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.common.Constant
import com.kotlin.WanAndroid.data.module.ListData
import com.kotlin.WanAndroid.data.module.ProjectListModel
import com.kotlin.WanAndroid.injection.component.DaggerWAComponent
import com.kotlin.WanAndroid.injection.module.WAModule
import com.kotlin.WanAndroid.presenter.ProjectListPresenter
import com.kotlin.WanAndroid.presenter.view.ProjectsView
import com.kotlin.WanAndroid.ui.adapter.ProjectListAdapter
import com.kotlin.base.listener.RecyclerViewScrollListener
import com.kotlin.base.ui.adapter.LoadMoreWrapper
import com.kotlin.base.ui.fragment.BaseMvpFragment
import kotlinx.android.synthetic.main.fragment_projects.*

/**
 *  项目类别下的Fragment
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class ProjectListFragment : BaseMvpFragment<ProjectListPresenter>(), ProjectsView {

    private var page: Int = 1
    private var cid: Int = 0
    private var pageSize = 0


    private lateinit var proListAdapter: ProjectListAdapter
    private lateinit var wrapper: LoadMoreWrapper
    private var allDatas = mutableListOf<ListData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_projects, container, false)
    }


    companion object {

        fun instance(id: Int): ProjectListFragment {

            var f = ProjectListFragment()

            var bundle = Bundle()
            bundle.putInt(Constant.FRAGMENT_CID, id)
            f.arguments = bundle

            return f

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        loadData()
    }

    private fun loadData() {
        var bundle = arguments
        cid = bundle!!.getInt(Constant.FRAGMENT_CID)

        mPresenter.getProjectList(page, cid)

    }


    override fun injectionComponent() {

        DaggerWAComponent.builder()
            .activityComponent(activityComponent)
            .wAModule(WAModule())
            .build()
            .inject(this)

        mPresenter.mView = this

    }


    override fun projectListResult(t: ProjectListModel) {

        pageSize = t.pageCount



        if (page == 0) {
            allDatas.clear()
            allDatas = t.datas as MutableList<ListData>

        } else {
            allDatas.addAll(t.datas)
        }
        proListAdapter.setData(allDatas)

        if (wrapper != null) {
            wrapper.setLoadState(wrapper.LOADING_COMPLETE)
        }


    }


    private fun initRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        mRecyclerView.addItemDecoration(DividerItemDecoration(activity, LinearLayout.VERTICAL))

        proListAdapter = ProjectListAdapter(activity!!)
        wrapper = LoadMoreWrapper(proListAdapter)
        mRecyclerView.adapter = wrapper


        // RecyclerView 加载更多 ;
        mRecyclerView.addOnScrollListener(object : RecyclerViewScrollListener() {
            override fun loadMore() {


                if (page < pageSize) {

                    page++
                    mPresenter.getProjectList(page, cid)
                    wrapper.setLoadState(wrapper.LOADING)

                } else {

                    wrapper.setLoadState(wrapper.LOADING_END)
                }


            }

        })


    }

}
