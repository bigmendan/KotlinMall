package com.kotlin.avcenter.common

import android.app.Application
import com.tencent.rtmp.TXLiveBase

/**
 * @author : ${Zhang}
 * @Date   : 2019/6/13 10:41:31
 * @Des    :
 */
class AvApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val licenceURL = "http://license.vod2.myqcloud.com/license/v1/df82dc8fb0631074dfb8daef413f1b40/TXLiveSDK.licence" // 获取到的 licence url
        val licenceKey = "db1fda04ab75ac57fc0901bb470d2043" // 获取到的 licence key
        TXLiveBase.getInstance().setLicence(this, licenceURL, licenceKey)
    }
}