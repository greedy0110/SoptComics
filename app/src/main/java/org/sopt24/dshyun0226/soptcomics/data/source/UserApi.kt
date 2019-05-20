package org.sopt24.dshyun0226.soptcomics.data.source

import io.reactivex.Observable
import org.sopt24.dshyun0226.soptcomics.network.post.PostSignupResponse

interface UserApi {
    fun requestToken(id: String, pw: String): Observable<String>
    fun requestSignup(name: String, id:String, pw:String): Observable<PostSignupResponse>
}