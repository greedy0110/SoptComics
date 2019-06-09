package org.sopt24.dshyun0226.soptcomics.repository

interface UserDataSource {
    fun setUserToken(token: String)
    fun getUserToken(): String
    fun clearUserToken()
}