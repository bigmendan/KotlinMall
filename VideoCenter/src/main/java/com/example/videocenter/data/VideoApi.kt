package com.example.videocenter.data

import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/18 15:32:00
 * @Des    :
 */
interface VideoApi {

    /**
     *  注册接口
     */
    @FormUrlEncoded
    @POST("user/register")
    fun register(
        @Field("username") username: String, @Field("password") password: String,
        @Field("repassword") repassword: String
    ): Observable<ResponseBody>


}