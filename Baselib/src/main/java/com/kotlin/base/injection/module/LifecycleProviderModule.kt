package com.kotlin.base.injection.module

import android.app.Activity
import com.trello.rxlifecycle3.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 14:09:11
 * @Des    :  注入 第三方的一个库 LifecycleProvider ， 只可以 使用@Module 的方法
 *           是在Activity 中使用的  ，就需要ActivityComponent 在引用这个 Module;
 */

@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providesLifecycleProvider(): LifecycleProvider<*> {
        return lifecycleProvider
    }
}