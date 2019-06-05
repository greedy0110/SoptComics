package org.sopt24.dshyun0226.soptcomics.api

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import khronos.toDate
import org.json.JSONObject
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.api.response.PostSignupResponse
import org.sopt24.dshyun0226.soptcomics.domain.model.ComicsEpisodeOverviewData
import org.sopt24.dshyun0226.soptcomics.domain.model.ComicsOverviewData
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SoptComicsRetrofitApi : SoptComicsApi {
    private val baseURL = "http://13.124.195.67:3000"

    private val retrofitSoptComicsApi by lazy { Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(SoptComicsRetrofitApiInterface::class.java)
    }


    override fun requestToken(id: String, pw: String): Observable<Int> {
        // Request Login
        val jsonObject = JSONObject().apply {
            // 보낼 데이터를 json 타입으로 만드는 것
            put("id", id)
            put("password", pw)
        }
        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        // 실제로 통신을 요청
        val postLoginResponse = retrofitSoptComicsApi.postLoginResponse("application/json", gsonObject)

        // TODO 안드로이드 종속성있는 여기에서 쓰레드 관리르 해야하나?
        return postLoginResponse.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map { it.data!! }
    }

    override fun requestSignup(name: String, id: String, pw: String): Observable<PostSignupResponse> {
        val jsonObject = JSONObject().apply {
            put("u_id", id)
            put("u_pw", pw)
            put("u_name", name)
        }

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        val postSignupResponse = retrofitSoptComicsApi.postSignupResponse("application/json", gsonObject)

        return postSignupResponse.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }

    // TODO 네트워크 데이터와 앱에서 사용할 domain 데이터와의 변형!
    override fun requestComicsOverviewList(kind: String): Observable<List<ComicsOverviewData>> {
        return retrofitSoptComicsApi.getMainProductListResponse("application/json", kindToFlag(kind))
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map {
                if (it.data == null) {
                    listOf()
                }
                else {
                    it.data?.map { getData ->
                        getData.run {
                            ComicsOverviewData(
                                thumnail = thumbnail,
                                idx = comics_idx,
                                title = title,
                                likes = likes,
                                name = writer,
                                isFinished = if (isfinished) 1 else 0
                            )
                        }
                    }
                }
            }
    }

    override fun requestComicsEpisodeOverviewList(comicsIndex: Int): Observable<Pair<Boolean, List<ComicsEpisodeOverviewData>>> {
        return retrofitSoptComicsApi.getComicsEpisodeOverviewListResponse("application/json", comicsIndex)
            .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map {
                if (it.data == null) {
                    Pair(false, listOf())
                }
                else {
                    Pair(it.data.liked,
                        it.data.episode_list.map { getEp ->
                            ComicsEpisodeOverviewData(
                                webtoon_id = getEp.episode_idx,
                                thumbnail_url = getEp.thumbnail,
                                title = getEp.title,
                                view_count = getEp.hits,
                                upload_date = getEp.datetime.toDate("yyyy.MM.dd HH:mm:SS")
                            )
                    })
                }
            }
    }

    private fun kindToFlag(kind: String):Int = when(kind) {
        "all" -> 1
        "new" -> 2
        "end" -> 3
        else -> 1
    }
}