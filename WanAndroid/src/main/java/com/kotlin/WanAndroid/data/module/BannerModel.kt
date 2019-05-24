package com.kotlin.WanAndroid.data.module

/**
 *  首页banner 的 Model
 */
data class BannerModel(
    val data: List<Data>
)

data class Data(
    val desc: String,
    val id: Int,
    val imagePath: String,
    val isVisible: Int,
    val order: Int,
    val title: String,
    val type: Int,
    val url: String
)