package com.kotlin.WanAndroid.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.google.android.material.tabs.TabLayout
import com.kotlin.WanAndroid.R
import com.kotlin.WanAndroid.ui.adapter.HomeTabAdapter
import com.kotlin.WanAndroid.ui.fragment.*
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.base.utils.StatusBarUtils
import com.kotlin.provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_home.*

/**
 *  WanAndroid  首页 ;
 */
@Route(path = RouterPath.WanAndroid.PATH_HOME)
class HomeActivity : BaseActivity() {

    private val homeFragment = HomeFragment()
    private val projectFragment = ProjectFragment()
    private val hotFragment = HotFragment()
    private val trendFragment = TrendFragment()
    private val systemFragment = SystemFragment()

    lateinit var homeTabAdapter: HomeTabAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        StatusBarUtils.darkMode(this)
        StatusBarUtils.setPaddingSmart(this, mToolBar)


        initTabLayout()
    }


    private fun initTabLayout() {

        var tabList = mutableListOf<String>("主页", "项目", "热门", "动态", "体系")

        var fragmentList =
            mutableListOf<Fragment>(homeFragment,projectFragment,
                hotFragment, trendFragment, systemFragment)


        homeTabAdapter = HomeTabAdapter(supportFragmentManager, tabList, fragmentList)

        mHomeVp.adapter = homeTabAdapter
        mTab.setupWithViewPager(mHomeVp)

        mTab.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener{
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                var position = tab!!.position
                Log.e("== ","tab被选中 $position")

                mHomeVp.currentItem=position
            }

        })



    }

    /**
     *  侧滑菜单 ，先等着吧
     */
    fun initNavigation() {


    }


}
