package com.kotlin.videocenter.injection.compoment

import com.kotlin.videocenter.injection.module.VideoModule
import com.kotlin.videocenter.ui.RegisterActivity
import com.kotlin.base.injection.component.ActivityComponent
import com.kotlin.base.injection.scope.PerComponentScope
import dagger.Component

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/18 15:28:38
 * @Des    :
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class), modules = arrayOf(VideoModule::class))
interface VideoComponent {

    fun inject(activity: RegisterActivity)

}