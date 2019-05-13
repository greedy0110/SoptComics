package org.sopt24.dshyun0226.androidseminar.network

import com.google.gson.JsonObject
import io.reactivex.Observable
import org.sopt24.dshyun0226.androidseminar.network.get.GetMainProductListResponse
import org.sopt24.dshyun0226.androidseminar.network.post.PostLoginResponse
import org.sopt24.dshyun0226.androidseminar.network.post.PostSignupResponse
import retrofit2.Call
import retrofit2.http.*

interface NetworkService {
    @POST("api/auth/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Observable<PostLoginResponse>

    @POST("api/auth/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Observable<PostSignupResponse>

    @GET("api/webtoons/main/{flag}")
    fun getMainProductListResponse(
        @Header("Content-Type") content_type: String,
        @Path("flag") flag: Int
    ): Observable<GetMainProductListResponse>
}