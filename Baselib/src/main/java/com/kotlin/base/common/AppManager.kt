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

    /**
     *  向栈内添加 Activity;
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /**
     *  移除所有的Activity ;
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /**
     * 当前栈顶的 Activity
     */
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