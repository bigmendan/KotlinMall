package com.kotlin.WanAndroid.injection.module

import com.kotlin.WanAndroid.data.repository.WanAndroidRepository
import dagger.Module
import dagger.Provides

@Module
class WAModule {
    @Provides
    fun provideRepository():WanAndroidRepository{
        return WanAndroidRepository()
    }
}