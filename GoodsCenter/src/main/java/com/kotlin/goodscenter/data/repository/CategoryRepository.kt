package com.kotlin.goodscenter.data.repository

import com.kotlin.base.data.net.RetrofitFactory
import com.kotlin.goodscenter.data.api.CategoryApi
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/30 17:08:05
 * @Des    :  将全部 category 的网络请求放在一个类里面;
 */

class CategoryRepository @Inject constructor() {


    fun service(): CategoryApi {
        return RetrofitFactory
            .instance
            .create(CategoryApi::class.java)

    }






}