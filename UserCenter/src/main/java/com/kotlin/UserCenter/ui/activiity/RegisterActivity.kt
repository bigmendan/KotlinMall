package com.kotlin.UserCenter.ui.activiity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.kotlin.UserCenter.R
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // 直接使用控件ID 进行事件监听
        register.setOnClickListener(View.OnClickListener {
            //            startActivity(intentFor<TestActivity>("id" to 8))
            startActivity<TestActivity>()
            toast("监听注册按钮")
        })
    }
}
