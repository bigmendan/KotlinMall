package com.kotlin.mall.ui.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kotlin.base.ui.fragment.BaseFragment

import com.kotlin.mall.R


class MeFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_me, container, false)
    }


    // 在这里去做一个 数据 操作 ;
    override fun onStart() {
        super.onStart()
    }

}
