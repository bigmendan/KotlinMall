package com.kotlin.base.data.net

import com.kotlin.base.common.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  在Kotlin 中使用单例模式
 *    私有的构造函数
 *    伴生对象  和 java 中的 静态类似
 */
class RetrofitFactory private constructor() {
    /**
     *  伴生对象
     *  1， 大多数情况下，Kotlin 推荐 使用包级别的 函数作为静态方法
     *   Kotlin 会将包级别的函数当做静态方法看待
     *  2， 在 Kotlin 中，一个类中只能有一个半生对象，名字可以省略，
     *   编译器会提供一个默认的名字 Companion
     *
     *   伴生对象看起来像是 java 中的静态成员，但是运行期仍是真实对象
     *   的实例成员
     *
     *   伴生对象在编译后会生成一个静态内部类
     *
     */
    companion object {
        // by lazy 就是线程安全的
        val instance: RetrofitFactory by lazy { RetrofitFactory() }
    }

    private var retrofit: Retrofit

    // 初始化时调用;
    init {
        retrofit = Retrofit.Builder()
            .baseUrl(Constant.SERVER_ADDRESS)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(initClient())
            .build()
    }


    private fun initClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(initLogInterceptor())
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()

    }

    // 日志拦截器
    private fun initLogInterceptor(): Interceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        return interceptor
    }
}

