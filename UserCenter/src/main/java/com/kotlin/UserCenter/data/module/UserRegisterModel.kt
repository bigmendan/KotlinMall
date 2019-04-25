package com.kotlin.UserCenter.data.module

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/24 15:26:24
 * @Des    :
 */
data class UserRegisterModel(
    val chapterTops: List<Any>,
    val collectIds: List<Any>,
    val email: String,
    val icon: String,
    val id: Int,
    val password: String,
    val token: String,
    val type: Int,
    val username: String
)