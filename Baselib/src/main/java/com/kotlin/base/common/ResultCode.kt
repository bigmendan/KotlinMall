package com.kotlin.base.common

/**
 * 网络请求返回错误码 ;  跟后台协商好 ;
 */
class ResultCode {
    companion object {

        const val SUCCESS = 0

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


}