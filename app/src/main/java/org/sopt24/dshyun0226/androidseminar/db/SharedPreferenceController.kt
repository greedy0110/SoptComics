package org.sopt24.dshyun0226.androidseminar.db

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    val MY_ACCOUNT = "unique_string"

    fun setUserToken(ctx: Context, data: String) {
        // 다른 어플리케이션에서 접근 할 수 없다.
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("token", data)
        editor.apply()
    }

    fun getUserToken(ctx: Context): String {
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return preferences.getString("token", "")!!
    }

    fun clearUserToken(ctx: Context) {
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("token", "")
        editor.apply()
    }
}
