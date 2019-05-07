package com.kotlin.UserCenter.ui.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.kotlin.UserCenter.Injection.component.DaggerRepositoryComponent
import com.kotlin.UserCenter.Injection.module.UserRepositoryModule
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.data.module.UserInfo
import com.kotlin.UserCenter.presenter.LoginPresenter
import com.kotlin.UserCenter.presenter.view.LoginView
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseMvpActivity
import com.kotlin.user.utils.UserPrefsUtils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

/**
 *  Login
 */
@Route(path = "/UserCenter/Login")
class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mLoginBt.onClick {
            mPresenter.login("赵文杰123123", "111111")
        }

    }

    override fun injectionComponent() {
        DaggerRepositoryComponent
            .builder()
            .activityComponent(activityComponent)
            .userRepositoryModule(UserRepositoryModule())
            .build()
            .inject(this)

        // 这里不要忘了 赋值 ;
        mPresenter.mView = this
    }

    override fun loginResult(info: UserInfo) {
        toast("登录成功")
        // 登录成功以后保存用户信息
        UserPrefsUtils.putUserInfo(info)
        finish()
    }

}
