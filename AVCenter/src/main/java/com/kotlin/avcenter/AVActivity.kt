package com.kotlin.avcenter

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.router.RouterPath

@Route(path = RouterPath.AVCenter.PATH_ZB)
class AVActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_av)
    }


}
