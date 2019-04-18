package com.example.videocenter.injection.compoment

import com.example.videocenter.injection.module.VideoModule
import com.example.videocenter.ui.RegisterActivity
import dagger.Component

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/18 15:28:38
 * @Des    :
 */
@Component(modules = arrayOf(VideoModule::class))
interface VideoComponent {

    fun inject(activity: RegisterActivity)

}