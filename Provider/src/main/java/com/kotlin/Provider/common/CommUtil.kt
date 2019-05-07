package com.kotlin.Provider.common

import com.kotlin.base.common.BaseConstant
import com.kotlin.base.utils.AppPrefsUtils

/**
 * @author : ${Zhang}
 * @Date   : 2019/5/7 15:03:00
 * @Des    :
 */

/**
 *  判断 用户是否登录
 */
fun isLogined(): Boolean {
    return AppPrefsUtils.getString(BaseConstant.KEY_SP_TOKEN).isNotEmpty()

}