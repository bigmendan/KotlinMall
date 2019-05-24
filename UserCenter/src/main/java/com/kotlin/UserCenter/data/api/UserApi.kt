package com.kotlin.UserCenter.data.api

import com.kotlin.UserCenter.data.module.UserInfo
import com.kotlin.UserCenter.data.module.UserRegister
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:31:06
 * @Des    :
 */
interface UserApi {

//    @POST("user/register")
//    fun register(@Body req: RegisterReq): Observable<BaseResp<String>


    @FormUrlEncoded
    @POST("/user/register")
    fun register(
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<BaseResp<UserRegister>>


    @FormUrlEncoded
    @POST("/user/login")
    fun login(
        @Field("username") username: String,
        @Field("password") password: String
    ): Observable<BaseResp<UserInfo>>

}