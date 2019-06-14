package com.kotlin.avcenter

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.kotlin.base.common.BaseApplication
import com.tencent.rtmp.TXLiveBase

class AvApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        var licenceURL = "db1fda04ab75ac57fc0901bb470d2043"; // 获取到的 licence url
        var licenceKey = "http://license.vod2.myqcloud.com/license/v1/df82dc8fb0631074dfb8daef413f1b40/TXLiveSDK.licence"; // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey);

    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }


}