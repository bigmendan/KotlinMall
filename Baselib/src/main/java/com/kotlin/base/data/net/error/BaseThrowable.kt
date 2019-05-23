package com.kotlin.base.data.net.error

import android.net.ParseException;

import com.google.gson.JsonParseException;
import com.kotlin.base.common.ResultCode

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

class BaseThrowable {

    class BaseThrowable(throwable: Throwable, var code: Int) : Exception(throwable) {
        override var message: String = ""
    }

    companion object {

        private const val UNAUTHORIZED = 401                           //  请求要求身份验证
        private const val FORBIDDEN = 403                              //  服务器拒绝请求
        private const val NOT_FOUND = 404                              //  服务器找不到请求的网页
        private const val REQUEST_TIMEOUT = 408                       //  服务器等候请求时发生超时
        private const val INTERNAL_SERVER_ERROR = 500                //  服务器遇到错误
        private const val BAD_GATEWAY = 502                           //  收到无效响应
        private const val SERVICE_UNAVAILABLE = 503                  //  服务器目前无法使用
        private const val GATEWAY_TIMEOUT = 504                      //  没有收到请求

        fun retrofitException(e: Throwable): BaseThrowable {
            val ex: BaseThrowable
            if (e is HttpException) {
                ex = BaseThrowable(e, ResultCode.HTTP_ERROR)
                when (e.code()) {
                    UNAUTHORIZED,
                    FORBIDDEN,
                    NOT_FOUND,
                    REQUEST_TIMEOUT,
                    GATEWAY_TIMEOUT,
                    INTERNAL_SERVER_ERROR,
                    BAD_GATEWAY,
                    SERVICE_UNAVAILABLE ->
                        ex.message = "网络异常"
                    else ->
                        ex.message = "网络错误"
                }
                return ex
            } /*else if (e is ServerException) {                    // 服务器下发的错误  自定义服务器异常;
                ex = BaseThrowable(e, e.code)
                ex.message = e.message
                return ex
            }*/ else if (e is JsonParseException || e is JSONException
                || e is ParseException
            ) {                                        // Json 解析错误 ;
                ex = BaseThrowable(e, ResultCode.PARSE_ERROR)
                ex.message = "解析错误"
                return ex
            } else if (e is ConnectException || e is SocketTimeoutException
                || e is UnknownHostException
            ) {
                ex = BaseThrowable(e, ResultCode.NETWORD_ERROR)
                ex.message = "连接失败"
                return ex
            } else if (e is SSLHandshakeException) {
                ex = BaseThrowable(e, ResultCode.SSL_ERROR)
                ex.message = "证书验证失败"
                return ex
            } else {
                ex = BaseThrowable(e, ResultCode.UNKNOWN)
                ex.message = "${ex.code} = 未知错误"
                return ex
            }
        }
    }
}