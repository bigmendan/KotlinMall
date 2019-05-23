package com.kotlin.base.data.net.error

import android.widget.Toast
import android.content.Context



/**
 * @author : ${Zhang}
 * @Date   : 2019/4/28 15:24:53
 * @Des    :
 */
class NetWorkError {

    /**
     * @param context 可以用于跳转Activity等操作
     */
    fun error(context: Context, throwable: Throwable) {
        val responseThrowable = RetrofitException.retrofitException(throwable)
        // 此处可以通过判断错误代码来实现根据不同的错误代码做出相应的反应
        when (responseThrowable.code) {
            RetrofitException.ERROR.UNKNOWN, RetrofitException.ERROR.PARSE_ERROR, RetrofitException.ERROR.NETWORD_ERROR, RetrofitException.ERROR.HTTP_ERROR, RetrofitException.ERROR.SSL_ERROR -> Toast.makeText(
                context,
                responseThrowable.message,
                Toast.LENGTH_SHORT
            ).show()
            -1 -> {
            }
            else -> Toast.makeText(context, responseThrowable.message, Toast.LENGTH_SHORT).show()
        }// 跳转到登陆页面
    }
}