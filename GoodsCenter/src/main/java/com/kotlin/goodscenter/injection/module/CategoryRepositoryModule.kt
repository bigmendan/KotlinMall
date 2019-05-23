package com.kotlin.goodscenter.injection.module

import com.kotlin.goodscenter.data.repository.CategoryRepository
import dagger.Module
import dagger.Provides

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/30 17:16:09
 * @Des    :
 */
@Module
class CategoryRepositoryModule {

    @Provides
    fun getCategoryRepository(): CategoryRepository {
        return CategoryRepository()
    }


}