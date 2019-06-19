package com.kotlin.base.utils.permission


import android.annotation.TargetApi
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class PermissionFragment : Fragment() {
    private var listener: PermissionListener? = null

    fun setListener(listener: PermissionListener) {
        this.listener = listener
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    @TargetApi(Build.VERSION_CODES.M)
    fun requestPermissions(permissions: Array<String>) {
        val requestPermissionList = ArrayList<String>()
        //找出所有未授权的权限
        for (permission in permissions) {
            if (ContextCompat.checkSelfPermission(context!!, permission) != PackageManager.PERMISSION_GRANTED) {
                requestPermissionList.add(permission)
            }
        }

        if (requestPermissionList.isEmpty()) {
            //已经全部授权
            permissionAllGranted()
        } else {
            //申请授权
            requestPermissions(requestPermissionList.toTypedArray(), PERMISSIONS_REQUEST_CODE)
        }
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != PERMISSIONS_REQUEST_CODE) {
            return
        }

        if (grantResults.size > 0) {
            val deniedPermissionList = ArrayList<String>()
            for (i in grantResults.indices) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    deniedPermissionList.add(permissions[i])
                }
            }

            if (deniedPermissionList.isEmpty()) {
                //已经全部授权
                permissionAllGranted()
            } else {

                //勾选了对话框中”Don’t ask again”的选项, 返回false
                for (deniedPermission in deniedPermissionList) {
                    val flag = shouldShowRequestPermissionRationale(deniedPermission)
                    if (!flag) {
                        //拒绝授权
                        permissionShouldShowRationale(deniedPermissionList)
                        return
                    }
                }
                //拒绝授权
                permissionHasDenied(deniedPermissionList)

            }
        }
    }


    /**
     * 权限全部已经授权
     */
    private fun permissionAllGranted() {
        if (listener != null) {
            listener!!.onGranted()
        }
    }

    /**
     * 权限被拒绝
     *
     * @param deniedList 被拒绝的权限List
     */
    private fun permissionHasDenied(deniedList: List<String>) {
        if (listener != null) {
            listener!!.onDenied(deniedList)
        }

    }

    /**
     * 权限被拒绝并且勾选了不再询问
     *
     * @param deniedList 勾选了不在询问的权限List
     */
    private fun permissionShouldShowRationale(deniedList: List<String>) {
        if (listener != null) {
            listener!!.onShouldShowRationale(deniedList)
        }
    }

    companion object {


        /**
         * requestCode
         */
        private val PERMISSIONS_REQUEST_CODE = 1
    }


}
