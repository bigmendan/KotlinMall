package com.kotlin.user.utils

import com.kotlin.UserCenter.data.module.UserInfo
import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.provider.common.ProviderConstant


/*
    本地存储用户相关信息
 */
object UserPrefsUtils {

    /*
        退出登录时，传入null,清空存储
         根据实际数据结构 填写 ;
     */
    fun putUserInfo(userInfo: UserInfo?) {
        // 在登录信息中获取到 token  并且存储;
        AppPrefsUtils.putInt(BaseConstant.KEY_SP_TOKEN, userInfo?.id ?: 0)

        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_ICON, userInfo?.icon ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.username ?: "")

//        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE, userInfo?.userMobile ?: "")
//        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
//        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_SIGN, userInfo?.userSign ?: "")
    }
}
