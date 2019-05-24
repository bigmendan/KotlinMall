package com.kotlin.base.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.kotlin.base.common.AppManager
import com.trello.rxlifecycle3.components.support.RxAppCompatActivity

/**
 *  有的页面是静态的 不需要继承 MVP ,
 *  只是需要有个静态资源，所有就有个 BaseActivity  继承使用 RxLifecycle 的Activity
 */
open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        AppManager.instance.addActivity(this)

    }


    override fun onDestroy() {
        super.onDestroy()
        AppManager.instance.finishActivity(this)
    }

}