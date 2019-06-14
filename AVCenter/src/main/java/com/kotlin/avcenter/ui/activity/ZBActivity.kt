package com.kotlin.avcenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.avcenter.R
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.router.RouterPath

@Route(path = RouterPath.AVCenter.PATH_ZB)
class ZBActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zb)
    }
}
