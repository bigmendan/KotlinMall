package com.kotlin.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 16:50:53
 * @Des    :  是一个 栈的管理 ;
 */
class AppManager private constructor() {

    // 栈
    private val activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy {
            AppManager()
        }
    }

    /**
     *   入栈  向栈内添加 Activity;
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     *   出栈 -- 移除Activity ;
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 当前栈顶的 Activity
     */
    fun currentActivity(activity: Activity): Activity {
        return activityStack.lastElement()   // 压栈的形式
    }

    /**
     *   清空栈 -- 结束所有Activity
     */
    fun finishAllActivity() {
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }


    /**
     *  退出 应用程序
     */
    fun exitApp(context: Context) {
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        // 杀死后台进程 ?
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)


    }


}