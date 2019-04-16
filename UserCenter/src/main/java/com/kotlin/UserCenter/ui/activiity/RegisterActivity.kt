package com.kotlin.UserCenter.ui.activiity

import android.os.Bundle
import android.view.View
import com.kotlin.UserCenter.Injection.component.DaggerUserComponent
import com.kotlin.UserCenter.Injection.module.UserModule
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.presenter.RegisterPresenter
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.ui.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView {


    // 注册   在Activity 中 具体实现 RegisterView 中的方法 ;
    override fun onRegisterResult(result: Boolean) {

        toast("注册成功")

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        // 因为BaseMvpActivity 中传入的 是一个泛型，需要实例化 ;
//        mPresenter = RegisterPresenter()    // 目前是 通过实例化的方法
        // presenter 中的 View 引用 赋值;
//        mPresenter.mView = this


        initInjection()

        // 直接使用控件ID 进行事件监听
        register.setOnClickListener(View.OnClickListener {
            mPresenter.register("zahowenjie1", "123", "123")

        })

    }

    private fun initInjection() {

        DaggerUserComponent.builder().userModule(UserModule()).build().inject(this)
        mPresenter.mView = this

    }


}
