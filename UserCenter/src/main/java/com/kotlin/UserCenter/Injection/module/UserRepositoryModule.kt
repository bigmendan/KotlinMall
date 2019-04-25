package com.kotlin.UserCenter.Injection.module

import com.kotlin.UserCenter.data.respository.UserRepository
import dagger.Module
import dagger.Provides

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/16 11:54:07
 * @Des    :    新建 一个 Module 类， 其中 @Provides  标注创建实例的方法;
 */
@Module
class UserRepositoryModule() {
    @Provides
    fun providesRepository(): UserRepository {
        return UserRepository()
    }


}