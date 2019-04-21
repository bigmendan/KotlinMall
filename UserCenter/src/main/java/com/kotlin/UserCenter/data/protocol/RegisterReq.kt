package com.kotlin.UserCenter.data.protocol

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:33:34
 * @Des    :   data  数据类  ;
 */
data class RegisterReq(val mobile: String, val pwd: String,
                       val rePwd: String) {
}