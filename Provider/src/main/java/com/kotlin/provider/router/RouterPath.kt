package com.kotlin.provider.router

/*
    模块路由 路径定义
 */
object RouterPath {
    //用户模块
    class UserCenter {
        companion object {
            const val PATH_LOGIN = "/userCenter/login"
        }
    }


    class Main {
        companion object {
            const val PATH_MAIN = "/App/mainActivity"
        }
    }


}
