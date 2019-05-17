package com.kotlin.mall.ui.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.utils.StatusBarUtils
import com.kotlin.mall.R
import com.kotlin.mall.ui.adapter.BaseRecyclerAdapter
import com.kotlin.mall.ui.adapter.HomeTestAdapter
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/25 17:40:32
 * @Des    :
 */
@RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
class HomeFragment : BaseFragment() {


    lateinit var homeTestAdapter: HomeTestAdapter

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater?.inflate(R.layout.fragment_home, null)

    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        StatusBarUtils.darkMode(activity)
        StatusBarUtils.setPaddingSmart(activity, mHomeToolbar)

        initRecyclerView()
    }


    private fun initRecyclerView() {
        mRecyclerView.layoutManager = LinearLayoutManager(activity)

        homeTestAdapter = HomeTestAdapter(activity)

        mRecyclerView.adapter = homeTestAdapter

        mRecyclerView.addItemDecoration(DividerItemDecoration(activity, RecyclerView.VERTICAL))

        homeTestAdapter.setData(
            mutableListOf(
                "测试文档",
                "测试文件",
                "测试文档",
                "测试文件",
                "dd",
                "测试文档",
                "测试文件",
                "sss",
                "测试文档",
                "测试文件",
                "tes"
            )
        )

        homeTestAdapter.setOnItemClickListener(object : BaseRecyclerAdapter.OnItemClickListener<String> {
            override fun onItemClick(item: String, position: Int) {
                Log.e(" === Adapter = ", " 点击事件 = $item  +  $position")
            }


        })


    }

}