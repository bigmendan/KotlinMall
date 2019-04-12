package com.kotlin.UserCenter.ui.activiity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.presenter.LoginPresenter
import com.kotlin.UserCenter.presenter.view.LoginView
import com.kotlin.base.presenter.view.BaseView
import com.kotlin.base.ui.activity.BaseMvpActivity

class LoginActivity : BaseMvpActivity<LoginPresenter>(), LoginView {
    override fun login(result: Boolean) {

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        mPresenter = LoginPresenter()
        mPresenter.mView = this
    }
}
