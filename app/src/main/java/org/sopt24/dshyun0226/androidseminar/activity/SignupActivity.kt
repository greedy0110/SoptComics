package org.sopt24.dshyun0226.androidseminar.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_signup.*
import org.jetbrains.anko.toast
import org.json.JSONObject
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SoptApplication
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.post.PostSignupResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

    private val networkService: NetworkService by lazy {
        SoptApplication.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val edtOnFocusChangeListener: View.OnFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtSignupName.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupID.setOnFocusChangeListener(edtOnFocusChangeListener)
        edtSignupPW.setOnFocusChangeListener(edtOnFocusChangeListener)

        btnSignupSubmit.setOnClickListener {
            val signup_u_name: String = edtSignupName.text.toString()
            val signup_u_id = edtSignupID.text.toString()
            val signup_u_pw: String = edtSignupPW.text.toString()

            if(signup_u_name == "") edtSignupName.requestFocus()
            else if(signup_u_id == "") edtSignupID.requestFocus()
            else if(signup_u_pw == "") edtSignupPW.requestFocus()
            else{
                postSignupResponse(signup_u_id, signup_u_pw, signup_u_name)
            }
        }
    }

    fun postSignupResponse(u_id: String, u_pw: String, u_name: String){
        val jsonObject = JSONObject().apply {
            put("id", u_id)
            put("name", u_name)
            put("password", u_pw)
        }

        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        val postSignupResponse = networkService.postSignupResponse("application/json", gsonObject)

        postSignupResponse.subscribe {
            toast(it.message)
            if (it.status == 201) {
                finish()
            }
        }
    }
}
