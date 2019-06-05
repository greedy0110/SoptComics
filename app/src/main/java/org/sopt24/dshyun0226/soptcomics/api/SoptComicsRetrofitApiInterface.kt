package org.sopt24.dshyun0226.soptcomics.api

import com.google.gson.JsonObject
import io.reactivex.Observable
import org.sopt24.dshyun0226.soptcomics.api.response.*
import retrofit2.http.*

interface SoptComicsRetrofitApiInterface {
    @POST("/auth/users/signin")
    fun postLoginResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Observable<PostLoginResponse>

    @POST("/auth/users/signup")
    fun postSignupResponse(
        @Header("Content-Type") content_type: String,
        @Body() body: JsonObject
    ): Observable<PostSignupResponse>

    @GET("/webtoon/comics/sort/{flag}")
    fun getMainProductListResponse(
        @Header("Content-Type") content_type: String,
        @Path("flag") flag: Int
    ): Observable<GetMainProductListResponse>

    @GET("/webtoon/comics/{c_idx}")
    fun getComicsEpisodeOverviewListResponse(
        @Header("Content-Type") content_type: String,
        @Path("c_idx") c_idx: Int
    ): Observable<GetComicsEpisodeOverviewResponse>

    @GET("/webtoon/banner")
    fun getBannerImageUrls(
        @Header("Content-Type") content_type: String
    ): Observable<GetBannerImageUrlsResponse>
}