package com.kotlin.WanAndroid.common

import com.kotlin.base.common.BaseApplication
import com.tencent.rtmp.TXLiveBase

class App : BaseApplication() {


    override fun onCreate() {
        super.onCreate()

        val licenceURL = "http://license.vod2.myqcloud.com/license/v1/df82dc8fb0631074dfb8daef413f1b40/TXLiveSDK.licence" // 获取到的 licence url
        val licenceKey = "db1fda04ab75ac57fc0901bb470d2043" // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey)
    }
}