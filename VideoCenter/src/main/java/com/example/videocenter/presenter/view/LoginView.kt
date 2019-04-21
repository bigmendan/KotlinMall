package com.example.videocenter.presenter.view

import com.kotlin.base.presenter.view.BaseView

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/18 16:37:20
 * @Des    :
 */
interface LoginView : BaseView {


    fun login(username: String, password: String)
}