package com.example.videocenter.injection.module

import com.example.videocenter.presenter.view.LoginView
import com.example.videocenter.presenter.view.RegisterView
import dagger.Module
import dagger.Provides

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/18 15:27:19
 * @Des    :
 */
@Module
class VideoModule {


    @Provides
    fun provideRegister(registerView: RegisterView): RegisterView {
        return registerView
    }


//    @Provides
//    fun provideLogin(loginView: LoginView): LoginView {
//        return loginView
//    }
}