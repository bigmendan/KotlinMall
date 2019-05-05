package com.kotlin.base.common

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.kotlin.base.injection.component.AppComponent
import com.kotlin.base.injection.component.DaggerAppComponent
import com.kotlin.base.injection.module.AppModule

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 12:09:10
 * @Des    :
 */
class BaseApplication : Application() {

    lateinit var appComponent: AppComponent


    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()

        initAppInjection()

        context = this

        ARouter.openLog()
        ARouter.openDebug()
        ARouter.init(this)
    }

    private fun initAppInjection() {

        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }


}