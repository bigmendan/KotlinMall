package com.kotlin.mall.ui.activity

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationBar.BACKGROUND_STYLE_STATIC
import com.kotlin.base.common.AppManager
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.base.ui.fragment.BaseFragment
import com.kotlin.goodscenter.ui.fragment.CategoryFragment
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.*
import com.kotlin.provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*


@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
@Route(path = RouterPath.Main.PATH_MAIN)
class MainActivity : BaseActivity() {

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


        var manager = supportFragmentManager.beginTransaction()

        manager.add(R.id.mContainer, mHomeFragment)
        manager.add(R.id.mContainer, mCategoryFragment)
        manager.add(R.id.mContainer, mCartFragment)
        manager.add(R.id.mContainer, mMsgFragment)
        manager.add(R.id.mContainer, mMeFragment)
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

        // 点击的时候没有水波纹效果
        mBottomNavBar.setBackgroundStyle(BACKGROUND_STYLE_STATIC)
    }

    private fun changeFragment(position: Int) {

        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }

    /**
     *  重写 back 返回事件;
     */
    private var preTime: Long = 0

    override fun onBackPressed() {
        var time = System.currentTimeMillis()
        if (time - preTime > 2000) {
            toast(" 再按一次退出")
            preTime = time
        } else {
            AppManager.instance.exitApp(this)
        }

    }
}
