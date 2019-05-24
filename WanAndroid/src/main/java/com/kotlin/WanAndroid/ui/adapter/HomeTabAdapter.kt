package com.kotlin.WanAndroid.ui.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


/**
 * @author : ${Zhang}
 * @Date   : 2019/5/22 18:12:20
 * @Des    : 首页的tab 适配器
 */

class HomeTabAdapter(
    fm: FragmentManager,
    private val tabList: MutableList<String>,//存放标签页标题
    private val fragmentList: MutableList<Fragment>//存放ViewPager下的Fragment
) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tabList[position]
    }
}