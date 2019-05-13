package org.sopt24.dshyun0226.androidseminar.data.source

import android.content.Context
import android.content.SharedPreferences

class UserRepository(private val ctx: Context) : UserDataSource {
    private val MY_ACCOUNT = "unique_string"

    override fun setUserToken(token: String) {
        // 다른 어플리케이션에서 접근 할 수 없다.
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("token", token)
        editor.apply()
    }

    override fun getUserToken(): String {
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return preferences.getString("token", "")!!
    }

    override fun clearUserToken() {
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("token", "")
        editor.apply()
    }
}