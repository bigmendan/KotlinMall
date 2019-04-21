package com.kotlin.UserCenter.data.api

import com.kotlin.UserCenter.data.protocol.Register2Req
import com.kotlin.UserCenter.data.protocol.RegisterReq
import com.kotlin.base.data.protocol.BaseResp
import io.reactivex.Flowable
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import java.util.*

/**
 * @author : ${Zhang}
 * @Date   : 2019/4/15 10:31:06
 * @Des    :
 */
interface UserApi {

    @POST("user/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>


}