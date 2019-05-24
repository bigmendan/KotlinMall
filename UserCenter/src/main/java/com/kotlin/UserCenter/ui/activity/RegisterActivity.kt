package com.kotlin.UserCenter.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.UserCenter.Injection.component.DaggerRepositoryComponent

import com.kotlin.UserCenter.Injection.module.UserRepositoryModule
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.presenter.RegisterPresenter
import com.kotlin.UserCenter.presenter.view.RegisterView
import com.kotlin.base.ext.enable
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast
import org.jetbrains.anko.startActivity

/**
 *  引入 Dagger2 的作用是为了给应用的各部分解耦
 *    如果一个功能需要实例化另外一个对象来完成，这就是耦合，
 *    Dagger2 的引入就是为了解除这种耦合
 */
class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        // 判断注册按钮是否可用 ;
        mRegisterBtn.isEnabled = false
        mRegisterBtn.enable(mMobileEt) { isBtnEnable() }
        mRegisterBtn.enable(mPasswordEt) { isBtnEnable() }
        mRegisterBtn.enable(mRepasswordEt) { isBtnEnable() }

        mVerifyCodeBtn.onClick(this)
        mRegisterBtn.onClick(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.mVerifyCodeBtn -> {
                mVerifyCodeBtn.requestSendVerifyNumber()
                //TODO 同时 需要做请求发送短信验证码的接口请求，在返回结果中 做个 UI 提示 ;
            }

            R.id.mRegisterBtn -> {

                mPresenter.register(
                    mMobileEt.text.toString(),
                    mPasswordEt.text.toString(),
                    mRepasswordEt.text.toString()
                )
            }
        }
    }

    override fun injectionComponent() {

        DaggerRepositoryComponent
            .builder()
            .activityComponent(activityComponent)
            .userRepositoryModule(UserRepositoryModule())
            .build()
            .inject(this)
        // mPresenter 已经在BaseMvpActivity 中被声明 ;
        mPresenter.mView = this


    }

    // 注册   在Activity 中 具体实现 RegisterView 中的方法 ;
    override fun onRegisterResult(result: String) {

        toast("注册成功")
        startActivity<LoginActivity>()
        finish()


    }

    // 监听输入框内容是否为空
    private fun isBtnEnable(): Boolean {
        return mMobileEt.text.isNullOrEmpty().not()
                && mPasswordEt.text.isNullOrEmpty().not()
                && mRepasswordEt.text.isNullOrEmpty().not()
    }


}
