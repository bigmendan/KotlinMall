package com.kotlin.UserCenter.Injection.component

import com.kotlin.UserCenter.Injection.module.UserModule
import com.kotlin.UserCenter.ui.activiity.RegisterActivity
import dagger.Component

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/16 12:00:53
 * @Des    :  使用这个方式 在 RegisterActivity 中引用 注解
 */
@Component(modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity: RegisterActivity)

}