package org.sopt24.dshyun0226.androidseminar.db

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceController {

    val MY_ACCOUNT = "unique_string"

    fun setUserID(ctx: Context, u_id: String) {
        // 다른 어플리케이션에서 접근 할 수 없다.
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.putString("u_id", u_id)
        editor.apply()
    }

    fun getUserID(ctx: Context): String {
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        return preferences.getString("u_id", "")
    }

    fun clearUserID(ctx: Context) {
        val preferences: SharedPreferences = ctx.getSharedPreferences(MY_ACCOUNT, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear() // 모든 데이터를 다 날림
        editor.apply()
    }
}