package com.kotlin.base.data.protocol


/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:26:36
 * @Des    :   这里的字段名 和返回参数 要和后台商量好，写一致
 */
data class BaseResp<out T>(
    var errorCode: Int, var errorMsg: String,
    val data: T?
)