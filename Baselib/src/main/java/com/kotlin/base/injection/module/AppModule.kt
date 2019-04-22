package com.kotlin.base.injection.module

import android.content.Context
import com.kotlin.base.common.BaseApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/22 14:09:11
 * @Des    : 全局唯一的方法  比如在BaseApplication 中提供一个全局的 Context
 *      context 来源于 BaseApplication ;
 */
@Module
class  AppModule(private val context: BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}