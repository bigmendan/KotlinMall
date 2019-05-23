package com.kotlin.WanAndroid.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.WanAndroid.R
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.base.utils.StatusBarUtils
import com.kotlin.provider.router.RouterPath
import kotlinx.android.synthetic.main.activity_home.*

/**
 *  WanAndroid  首页 ;
 */
@Route(path = RouterPath.WanAndroid.PATH_HOME)
class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        StatusBarUtils.darkMode(this)
        StatusBarUtils.setPaddingSmart(this, mToolBar)

    }



    fun initTabLayout(){


    }




    fun initNavigation() {


    }


}
