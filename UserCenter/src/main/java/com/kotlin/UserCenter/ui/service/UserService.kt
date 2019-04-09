package com.kotlin.UserCenter.ui.service

import io.reactivex.Observable
import java.util.*

/**
 * time   :  2019/4/9
 * author :  Z
 * des    :
 */
interface UserService {

    fun register(mobile:String,verifyCode:String,pwd:String ):Observable<Boolean>
}