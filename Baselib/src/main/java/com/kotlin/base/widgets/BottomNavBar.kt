package com.kotlin.base.widgets

import android.content.Context
import android.util.AttributeSet
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.ashokvarma.bottomnavigation.BottomNavigationItem
import com.ashokvarma.bottomnavigation.ShapeBadgeItem
import com.ashokvarma.bottomnavigation.TextBadgeItem
import com.kotlin.base.R

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/25 16:39:54
 * @Des    : 初始化 底部导航栏
 */
class BottomNavBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : BottomNavigationBar(context, attrs, defStyleAttr) {



    private val mCartBadge: TextBadgeItem   // 显示数字
    private val mMsgBadge: ShapeBadgeItem      // 仅仅显示形状

    init {
        // 首页
        val homeItem = BottomNavigationItem(
            R.drawable.btn_nav_home_press,
            resources.getString(R.string.nav_bar_home)
        )
            .setInactiveIconResource(R.drawable.btn_nav_home_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        // 分类
        val categoryItem = BottomNavigationItem(
            R.drawable.btn_nav_category_press,
            resources.getString(R.string.nav_bar_category)
        )
            .setInactiveIconResource(R.drawable.btn_nav_category_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        // 购物车
        val cartItem = BottomNavigationItem(
            R.drawable.btn_nav_cart_press,
            resources.getString(R.string.nav_bar_cart)
        )
            .setInactiveIconResource(R.drawable.btn_nav_cart_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)


        mCartBadge = TextBadgeItem()
        cartItem.setBadgeItem(mCartBadge)


        //消息
        val msgItem = BottomNavigationItem(
            R.drawable.btn_nav_msg_press,
            resources.getString(R.string.nav_bar_msg)
        )
            .setInactiveIconResource(R.drawable.btn_nav_msg_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)

        mMsgBadge = ShapeBadgeItem()
        mMsgBadge.setShape(ShapeBadgeItem.SHAPE_OVAL)
        msgItem.setBadgeItem(mMsgBadge)

        //我的
        val userItem = BottomNavigationItem(
            R.drawable.btn_nav_user_press,
            resources.getString(R.string.nav_bar_user)
        )
            .setInactiveIconResource(R.drawable.btn_nav_user_normal)
            .setActiveColorResource(R.color.common_blue)
            .setInActiveColorResource(R.color.text_normal)


        // 设置模式
        setMode(BottomNavigationBar.MODE_FIXED)
        // 样式
        setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        // 设置背景颜色
        setBarBackgroundColor(R.color.common_white)

        addItem(homeItem)
            .addItem(categoryItem)
            .addItem(cartItem)
            .addItem(msgItem)
            .addItem(userItem)
            .setFirstSelectedPosition(0)        // 默认选中第一个
            .initialise()           // 调用初始化方法;

    }


    /**
     *    用来显示文字 的 Badge
     */
    fun checkCartBadge(count: Int) {
        if (count == 0) {
            mCartBadge.hide()
        } else {
            mCartBadge.setText(count.toString())
        }
    }


    /**
     *  用来显示  未读消息 的 小圆点 Badge
     */
    fun checkMsgBadge(isVisiable: Boolean) {
        if (isVisiable) {
            mMsgBadge.show()
        } else {
            mMsgBadge.hide()
        }
    }


}