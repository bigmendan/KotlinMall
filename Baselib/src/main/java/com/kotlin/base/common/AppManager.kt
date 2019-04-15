package com.kotlin.base.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 16:50:53
 * @Des    :
 */
class AppManager private constructor() {

    // 栈
    private val activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManager by lazy {
            AppManager()
        }
    }

    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    fun currentActivity(activity: Activity): Activity {
        return activityStack.lastElement()
    }

    /**
     *
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
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)


    }


}