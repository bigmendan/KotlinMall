package com.kotlin.UserCenter.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kotlin.UserCenter.R
import com.kotlin.UserCenter.presenter.UserInfoPresenter
import com.kotlin.UserCenter.presenter.view.UserInfoView
import com.kotlin.base.ui.activity.BaseMvpActivity

/**
 *  用户信息;  也可能就是在一个 Fragment 里面的
 */
class UserInfoActivity : BaseMvpActivity<UserInfoPresenter>(), UserInfoView {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uaser_info)
    }


    override fun injectionComponent() {

    }
}
