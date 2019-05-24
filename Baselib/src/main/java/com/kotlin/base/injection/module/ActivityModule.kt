package com.kotlin.base.injection.module


import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 14:09:11
 * @Des    : 全局唯一的方法  比如在BaseApplication 中提供一个全局的 Context
 *      context 来源于 BaseApplication ;
 */

@Module
class ActivityModule(private val activity: FragmentActivity) {

    @Provides
    fun providesActivity(): FragmentActivity {
        return activity
    }
}