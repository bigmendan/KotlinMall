package com.kotlin.videocenter.ui

import android.os.Bundle
import android.util.Log
import com.kotlin.videocenter.R
import com.kotlin.videocenter.injection.compoment.DaggerVideoComponent
import com.kotlin.videocenter.injection.module.VideoModule
import com.kotlin.videocenter.presenter.RegisterPresenter
import com.kotlin.videocenter.presenter.view.RegisterView
import com.kotlin.base.ui.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {


    override fun registerResult(result: Boolean) {

        Log.e("===", " 执行到 register +$result")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerBtn.setOnClickListener {
            mPresenter.register("zhaowenjie", "232323", "232323")
        }

    }

    override fun injectionComponent() {
        // 这里 的viewModule 划横线是个什么意思
        DaggerVideoComponent.builder().activityComponent(activityComponent).videoModule(VideoModule()).build()
            .inject(this)
        mPresenter.mView = this
    }


}
