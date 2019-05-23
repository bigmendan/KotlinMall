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
class AppModule(private val context: BaseApplication) {

    @Provides               // dagger 会根据Provider 标记的方法返回依赖对象
    @Singleton              // 如果 需要依赖对象是单例的话 就加上 Singleton 标注 ;
    fun providesContext(): Context {
        return context
    }


    /**
     *  如果 @Providers 修饰的方法中需要用到其他 @Providers 修饰的 参数 ，
     *  直接传递进来就好
     */




}