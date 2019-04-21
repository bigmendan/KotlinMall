package com.kotlin.base.data.protocol


/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:26:36
 * @Des    :  平时做网络请求 都会有的 几个参数 status ,message ，data
 */
class BaseResp<out T>(val status: Int, val message: String,
                      val data: T)