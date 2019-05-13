package org.sopt24.dshyun0226.androidseminar.data.source

import io.reactivex.Observable

interface TokenApi {
    fun getToken(id: String, pw: String): Observable<String>
}