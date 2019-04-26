package com.kotlin.mall.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.bumptech.glide.Glide
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.base.widgets.BottomNavBar
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val mStack = Stack<BaseFragment>()
    private val mHomeFragment by lazy { HomeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 在底部栏 添加一个 带数字的Badge
        mBottomNavBar.checkCartBadge(20)

        initFragment()
        initBottomNav()
        changeFragment(0)    // 默认使用第一个 ;
    }

    private fun initFragment() {
        val manager = fragmentManager.beginTransaction()
        manager.add(R.id.mContainer, mHomeFragment)


        manager.commit()

        mStack.add(mHomeFragment)

    }



    private fun initBottomNav() {
        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }

            override fun onTabUnselected(position: Int) {
            }

            /**
             *  在这个方法里实现切换
             */
            override fun onTabSelected(position: Int) {

                changeFragment(position)

            }

        })
    }

    private fun changeFragment(position: Int) {
        val manager = fragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }
}
