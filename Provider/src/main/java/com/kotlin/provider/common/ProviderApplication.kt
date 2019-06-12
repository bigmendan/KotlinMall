package com.kotlin.provider.common

import android.app.Application
import com.kotlin.base.common.BaseApplication
import com.tencent.bugly.crashreport.CrashReport

/**
 * @author : ${Zhang}
 * @Date   : 2019/6/12 11:46:33
 * @Des    :
 */
class ProviderApplication : Application() {

    //  app_id = "910e16f17e"
    override fun onCreate() {
        super.onCreate()

        CrashReport.initCrashReport(applicationContext, "910e16f17e", true);
    }
}