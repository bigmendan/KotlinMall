package com.kotlin.base.data.net.error

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 12:00:05
 * @Des    :
 */
class BaseException(val status: Int, val msg: String) : Throwable() {
}