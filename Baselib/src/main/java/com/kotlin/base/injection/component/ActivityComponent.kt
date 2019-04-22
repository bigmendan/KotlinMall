package com.kotlin.base.injection.component

import android.app.Activity
import com.kotlin.base.injection.scope.ActivityScope
import com.kotlin.base.injection.module.ActivityModule
import dagger.Component

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 14:08:43
 * @Des    :   这里还需要考虑作用域的问题;  (Scope)
 */
@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun activity(): Activity

}