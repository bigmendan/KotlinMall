package com.kotlin.UserCenter.presenter.view

import com.kotlin.base.presenter.view.BaseView
import javax.net.ssl.SSLEngineResult

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/12 12:17:29
 * @Des    :
 */
interface LoginView : BaseView {

    fun login(result: Boolean)
}