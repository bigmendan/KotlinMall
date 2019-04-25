package com.kotlin.UserCenter.data.api

import com.kotlin.UserCenter.data.module.UserRegisterModel
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
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
    @POST("user/register")
    fun register(
        @Field("username") username: String, @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<ResponseBody>


    @FormUrlEncoded
    @POST("user/register")
    fun register2(
        @Field("username") username: String, @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<BaseResp<UserRegisterModel>>


}