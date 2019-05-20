package org.sopt24.dshyun0226.soptcomics.data.source

import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import org.sopt24.dshyun0226.soptcomics.SoptApplication
import org.sopt24.dshyun0226.soptcomics.network.post.PostSignupResponse

class UserRetrofitApi : UserApi {
    override fun requestToken(id: String, pw: String): Observable<String> {
        // Request Login
        val jsonObject = JSONObject().apply {
            // 보낼 데이터를 json 타입으로 만드는 것
            put("id", id)
            put("password", pw)
        }
        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        // 실제로 통신을 요청
        val postLoginResponse = SoptApplication.instance.networkService.postLoginResponse("application/json", gsonObject)

        // TODO 안드로이드 종속성있는 여기에서 쓰레드 관리르 해야하나?
        return postLoginResponse.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map { it.data!! }
    }

    override fun requestSignup(name: String, id: String, pw: String): Observable<PostSignupResponse> {
        val jsonObject = JSONObject().apply {
            put("id", id)
            put("name", name)
            put("password", pw)
        }

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        val postSignupResponse = SoptApplication.instance.networkService.postSignupResponse("application/json", gsonObject)

        return postSignupResponse.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
    }
}