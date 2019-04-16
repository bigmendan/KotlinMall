package com.kotlin.UserCenter.Injection.module

import com.kotlin.UserCenter.ui.service.UserService
import com.kotlin.UserCenter.ui.service.impl.UserServiceImpl
import dagger.Module
import dagger.Provides

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/16 11:54:07
 * @Des    :
 */
@Module
class UserModule {


    @Provides
    fun providesUserServices(service: UserServiceImpl):UserService{

        return  service
    }

}