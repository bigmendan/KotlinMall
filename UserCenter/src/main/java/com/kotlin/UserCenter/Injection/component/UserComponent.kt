package com.kotlin.UserCenter.Injection.component

import com.kotlin.UserCenter.Injection.module.UserModule
import com.kotlin.UserCenter.ui.activiity.RegisterActivity
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.module.ActivityModule
import com.kotlin.base.injection.scope.PerComponentScope
import dagger.Component

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/16 12:00:53
 * @Des    :  使用这个方式 在 RegisterActivity 中引用 注解
 *
 *   原本 UserComponent 没有作用域，不可以依赖有作用域的ActivityComponent;
 *
 *    去依赖的 Component 有一个Scope,本身也需要去有一个Scope;
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(UserModule::class))
interface UserComponent {

    fun inject(activity: RegisterActivity)

}