package com.kotlin.mall.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManagerNonConfig
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    private val mStack = Stack<BaseFragment>()
    private val mHomeFragment by lazy { HomeFragment() }
    private val mCategoryFragment by lazy { CategoryFragment() }
    private val mCartFragment by lazy { CartFragment() }
    private val mMsgFragment by lazy { MsgFragment() }
    private val mMeFragment by lazy { MeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        // 在底部栏 添加一个 带数字的Badge
        mBottomNavBar.checkCartBadge(20)

        initFragment()

        changeFragment(0)    // 默认使用第一个 ;

        initBottomNav()
    }

    private fun initFragment() {

        val manager = fragmentManager.beginTransaction()
        manager.add(R.id.mContainer, mHomeFragment)
            .add(R.id.mContainer, mCategoryFragment)
            .add(R.id.mContainer, mCartFragment)
            .add(R.id.mContainer, mMsgFragment)
            .add(R.id.mContainer, mMeFragment)

        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)

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
