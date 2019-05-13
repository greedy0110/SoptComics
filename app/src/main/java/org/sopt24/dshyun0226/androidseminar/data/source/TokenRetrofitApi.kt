package org.sopt24.dshyun0226.androidseminar.data.source

import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.json.JSONObject
import org.sopt24.dshyun0226.androidseminar.SoptApplication
import org.sopt24.dshyun0226.androidseminar.network.post.PostLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// TODO 비동기적으로 데이터를 반환해줘야 하는데
class TokenRetrofitApi : TokenApi {
    override fun getToken(id: String, pw: String): Observable<String> {
        // Request Login
        val jsonObject = JSONObject().apply {
            // 보낼 데이터를 json 타입으로 만드는 것
            put("id", id)
            put("password", pw)
        }
        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        // 실제로 통신을 요청
        val postLoginResponse = SoptApplication.instance.networkService.postLoginResponse("application/json", gsonObject)


        return postLoginResponse.map { it.data!! }
    }
}