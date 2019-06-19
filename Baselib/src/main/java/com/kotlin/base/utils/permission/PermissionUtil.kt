package com.kotlin.base.utils.permission

import androidx.fragment.app.FragmentManager

/**
 * Created by EDZ on 2018/7/3.
 * 申请权限 工具类  ，需要在清单文件中先填写相关权限
 *
 *
 * 使用方法：
 * new PermissionUtil(this).requestPermissions(new String[]{Manifest.permission.CAMERA, Manifest.permission.CALL_PHONE},
 * new  PermissionListener(){
 *
 * @Override public void onGranted() {
 * //所有权限都已经授权
 *
 *
 * }
 * @Override public void onDenied(List<String> deniedPermission) {
 * //Toast第一个被拒绝的权限
</String> *
 *
 * }
 * @Override public void onShouldShowRationale(List<String> deniedPermission) {
 * //Toast第一个勾选不在提示的权限
</String> *
 *
 * }
 * })
 */

class PermissionUtil(fm: FragmentManager) {

    private val fragment: PermissionFragment

    init {
        fragment = getRxPermissionsFragment(fm)
    }

    private fun getRxPermissionsFragment(fm: FragmentManager): PermissionFragment {
        var fragment = fm.findFragmentByTag(TAG) as PermissionFragment?
        val isNewInstance = fragment == null
        if (isNewInstance) {
            fragment = PermissionFragment()
            fm.beginTransaction()
                .add(fragment, TAG)
                .commit()
            fm.executePendingTransactions()
        }

        return fragment!!
    }

    /**
     * 外部使用 申请权限
     *
     * @param permissions 申请授权的权限
     * @param listener    授权回调的监听
     */
    fun requestPermissions(permissions: Array<String>, listener: PermissionListener) {
        fragment.setListener(listener)
        fragment.requestPermissions(permissions)

    }

    companion object {
        private val TAG = PermissionUtil::class.java.simpleName
    }

}
