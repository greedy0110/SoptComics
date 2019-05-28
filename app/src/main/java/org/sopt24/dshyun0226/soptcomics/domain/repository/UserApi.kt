package org.sopt24.dshyun0226.soptcomics.domain.repository

import io.reactivex.Observable
import org.sopt24.dshyun0226.soptcomics.domain.model.response.PostSignupResponse

interface UserApi {
    fun requestToken(id: String, pw: String): Observable<String>
    fun requestSignup(name: String, id:String, pw:String): Observable<PostSignupResponse>
}