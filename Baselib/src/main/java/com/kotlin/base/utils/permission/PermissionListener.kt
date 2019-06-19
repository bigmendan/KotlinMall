package com.kotlin.base.utils.permission

/**
 * Created by EDZ on 2018/7/3.
 */

interface PermissionListener {
    fun onGranted()

    fun onDenied(deniedPermission: List<String>)

    fun onShouldShowRationale(deniedPermission: List<String>)
}
