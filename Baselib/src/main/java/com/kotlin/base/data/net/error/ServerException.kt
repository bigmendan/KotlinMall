package com.kotlin.base.data.net.error

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/28 15:29:38
 * @Des    :
 */

class ServerException(var code: Int, message: String) : RuntimeException(message)