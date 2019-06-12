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
import com.kotlin.WanAndroid.data.module.SystemTreeModel
import com.kotlin.WanAndroid.injection.component.DaggerWAComponent
import com.kotlin.WanAndroid.presenter.SystemPresenter
import com.kotlin.WanAndroid.presenter.view.SystemView
import com.kotlin.WanAndroid.ui.adapter.SystemAdapter
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.base.ui.fragment.BaseMvpLazyFragment
import kotlinx.android.synthetic.main.fragment_system.*


/**
 *  体系 Fragment
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class SystemFragment : BaseMvpFragment<SystemPresenter>(), SystemView {


    private lateinit var sysAdapter: SystemAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_system, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        mPresenter.getSystemTree()
    }

//    override fun initDatas() {
//        initRecyclerView()
//        mPresenter.getSystemTree()
//    }


    private fun initRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(activity)
        mRecyclerView.addItemDecoration(DividerItemDecoration(activity!!, LinearLayout.VERTICAL))
        sysAdapter = SystemAdapter(activity!!)
        mRecyclerView.adapter = sysAdapter
    }


    override fun injectionComponent() {

        DaggerWAComponent
            .builder()
            .activityComponent(activityComponent)
            .build()
            .inject(this)

        mPresenter.mView = this
    }

    override fun getSystemTree(list: List<SystemTreeModel>) {
        sysAdapter.setData(list)
    }
}
