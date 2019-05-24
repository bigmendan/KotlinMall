package com.kotlin.base.injection.component

import android.content.Context
import com.kotlin.base.injection.module.AppModule
import dagger.Component
import javax.inject.Singleton

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 14:08:43
 * @Des    :
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun context(): Context

}