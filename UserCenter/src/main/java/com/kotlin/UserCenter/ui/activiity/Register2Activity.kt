package com.kotlin.UserCenter.ui.activiity

import android.os.Bundle
import android.view.View
import com.kotlin.UserCenter.R

import com.kotlin.UserCenter.presenter.Register2Presenter
import com.kotlin.UserCenter.presenter.view.LoginView
import com.kotlin.base.common.AppManager
import com.kotlin.base.ui.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class Register2Activity : BaseMvpActivity<Register2Presenter>(), LoginView {

    var pressTime: Long = 0

    override fun login(result: Boolean) {

        toast("注册成功")
    }

    fun fail() {
        toast(" 失败")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        mPresenter = Register2Presenter()
        mPresenter.mView = this


        registerBtn.setOnClickListener(View.OnClickListener {
            mPresenter.register2("15534551234", "123123", "123123")
        })


    }

    override fun onBackPressed() {


        var time: Long = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再按一次退出")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }

    }

}
