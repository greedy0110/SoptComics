package org.sopt24.dshyun0226.androidseminar.data.source

import io.reactivex.Observable
import io.reactivex.ObservableEmitter

class TokenLocalApi : TokenApi {
    override fun getToken(id: String, pw: String): Observable<String>
            = Observable.just("dummy token")
}