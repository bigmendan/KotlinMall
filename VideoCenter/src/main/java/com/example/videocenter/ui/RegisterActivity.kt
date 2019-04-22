package com.example.videocenter.ui

import android.os.Bundle
import android.util.Log
import com.example.videocenter.R
import com.example.videocenter.injection.compoment.DaggerVideoComponent
import com.example.videocenter.injection.module.VideoModule
import com.example.videocenter.presenter.RegisterPresenter
import com.example.videocenter.presenter.view.RegisterView
import com.kotlin.base.ui.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {

    override fun registerResult(result: Boolean) {

        Log.e("===", " 执行到 register +$result")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        initDagger()

        registerBtn.setOnClickListener {
            mPresenter.register("zhaowenjie", "232323", "232323")
        }

    }

    // 用来实例化 Presenter  ;
    private fun initDagger() {
        // 这里 的viewModule 划横线是个什么意思
        DaggerVideoComponent.builder().activityComponent(activityComponent).videoModule(VideoModule()).build().inject(this)
        mPresenter.mView = this

    }


}
