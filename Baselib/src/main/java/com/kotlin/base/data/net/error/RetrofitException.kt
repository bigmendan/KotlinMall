package com.kotlin.base.data.net.error

import android.net.ParseException;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import javax.net.ssl.SSLHandshakeException;

import retrofit2.HttpException;


/**
 * @author : ${Zhang}
 * @Date   : 2019/4/28 15:27:26
 * @Des    :
 */

class RetrofitException {


    /**
     * 约定异常
     */
    internal object ERROR {
        /**
         * 未知错误
         */
        const val UNKNOWN = 1000
        /**
         * 解析错误
         */
        const val PARSE_ERROR = 1001
        /**
         * 网络错误
         */
        const val NETWORD_ERROR = 1002
        /**
         * 协议出错
         */
        const val HTTP_ERROR = 1003
        /**
         * 证书出错
         */
        const val SSL_ERROR = 1005
    }

    class ResponeThrowable(throwable: Throwable, var code: Int) : Exception(throwable) {
        override var message: String? = null
    }

    companion object {

        private const val UNAUTHORIZED = 401
        private const val FORBIDDEN = 403
        private const val NOT_FOUND = 404
        private const val REQUEST_TIMEOUT = 408
        private const val INTERNAL_SERVER_ERROR = 500
        private const val BAD_GATEWAY = 502
        private const val SERVICE_UNAVAILABLE = 503
        private const val GATEWAY_TIMEOUT = 504

        fun retrofitException(e: Throwable): ResponeThrowable {
            val ex: ResponeThrowable
            if (e is HttpException) {
                val httpException = e
                ex = ResponeThrowable(e, ERROR.HTTP_ERROR)
                when (httpException.code()) {
                    UNAUTHORIZED, FORBIDDEN, NOT_FOUND, REQUEST_TIMEOUT, GATEWAY_TIMEOUT, INTERNAL_SERVER_ERROR, BAD_GATEWAY, SERVICE_UNAVAILABLE -> ex.message =
                        "网络错误"
                    else -> ex.message = "网络错误"
                }
                return ex
            } else if (e is ServerException) {
                // 服务器下发的错误
                val resultException = e
                ex = ResponeThrowable(resultException, resultException.code)
                ex.message = resultException.message
                return ex
            } else if (e is JsonParseException
                || e is JSONException
                || e is ParseException
            ) {
                ex = ResponeThrowable(e, ERROR.PARSE_ERROR)
                ex.message = "解析错误"
                return ex
            } else if (e is ConnectException
                || e is SocketTimeoutException
                || e is UnknownHostException
            ) {
                ex = ResponeThrowable(e, ERROR.NETWORD_ERROR)
                ex.message = "连接失败"
                return ex
            } else if (e is SSLHandshakeException) {
                ex = ResponeThrowable(e, ERROR.SSL_ERROR)
                ex.message = "证书验证失败"
                return ex
            } else {
                ex = ResponeThrowable(e, ERROR.UNKNOWN)
                ex.message = "未知错误"
                return ex
            }
        }
    }
}