package com.kotlin.WanAndroid.data.module


data class ArticleModel(
    val curPage: Int,
    val articleDatas: List<ArticleData>,
    val offset: Int,
    val over: Boolean,
    val pageCount: Int,
    val size: Int,
    val total: Int
)

data class ArticleData(
    val apkLink: String,
    val author: String,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    val niceDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val superChapterId: Int,
    val superChapterName: String,
    val tags: List<Any>,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
)