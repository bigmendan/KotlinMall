package com.kotlin.WanAndroid.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.WanAndroid.R
import com.kotlin.base.ext.loge
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.fragment.BaseFragment
import kotlinx.android.synthetic.main.fragment_trend.*


class TrendFragment : BaseFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trend, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn.onClick {
//            loge("Bugly 为什么崩溃退出")
//            CrashReport.testJavaCrash();
        }
    }


}
