package com.kotlin.UserCenter.Injection.component

import com.kotlin.UserCenter.Injection.module.UserRepositoryModule
import com.kotlin.UserCenter.ui.activity.RegisterActivity
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.scope.PerComponentScope
import dagger.Component

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/16 12:00:53
 * @Des    :  使用这个方式 在 RegisterActivity 中引用 注解
 *
 *    @PerComponentScope 是 一个自定义 Scope ,因为 ActivityComponent 中也是有 Scope(ActivityScope) 修饰的
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(UserRepositoryModule::class))
interface RepositoryComponent {

    fun inject(activity: RegisterActivity)

}