package org.sopt24.dshyun0226.soptcomics.domain.repository

interface UserDataSource {
    fun setUserToken(token: String)
    fun getUserToken(): String
    fun clearUserToken()
}