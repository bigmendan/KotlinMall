package com.kotlin.WanAndroid.ui.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.kotlin.WanAndroid.R
import com.kotlin.base.ui.fragment.BaseFragment


/**
 *  体系 Fragment
 */
class SystemFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_system, container, false)
    }


}
