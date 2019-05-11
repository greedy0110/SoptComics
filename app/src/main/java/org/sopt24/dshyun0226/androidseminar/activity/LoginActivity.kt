package org.sopt24.dshyun0226.androidseminar.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import org.json.JSONObject
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SoptApplication
import org.sopt24.dshyun0226.androidseminar.db.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.post.PostLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1000

    private val networkService: NetworkService by lazy {
        SoptApplication.instance.networkService
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtLoginID.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        edtLoginPW.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus) v.setBackgroundResource(R.drawable.primary_border)
            else v.setBackgroundResource(R.drawable.gray_border)
        }

        btnLoginSubmit.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()

            if(login_u_id == "") edtLoginID.requestFocus()
            else if(login_u_pw == "") edtLoginPW.requestFocus()
            else postLoginResponse(login_u_id, login_u_pw)
        }

        txtLoginSignup.setOnClickListener{
            val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val s_time = simpleDateFormat.format(Date())

            startActivityForResult<SignupActivity>(REQUEST_CODE, "start_time" to s_time)
        }

    }

    private fun postLoginResponse(u_id: String, u_pw: String){
        // Request Login
        val jsonObject = JSONObject().apply {
            // 보낼 데이터를 json 타입으로 만드는 것
            put("id", u_id)
            put("password", u_pw)
        }
        val gsonObject = JsonParser().parse(jsonObject.toString()) as JsonObject

        // 실제로 통신을 요청
        val postLoginResponse: Call<PostLoginResponse> =
            networkService.postLoginResponse("application/json", gsonObject)

        Log.d("login", "postLoginResponse")

        // 통신 응답에 따라 올바른 행동을 하도록 해야한다.
        postLoginResponse.enqueue(object : Callback<PostLoginResponse>{
            override fun onFailure(call: Call<PostLoginResponse>, t: Throwable) {
                Log.e("login failed", t.toString())
            }

            override fun onResponse(call: Call<PostLoginResponse>, response: Response<PostLoginResponse>) {
                Log.d("login", "success ${response.body()}")

                if (response.isSuccessful) {
                    if (response.body()!!.status == 201) {
                        SharedPreferenceController.setUserToken(applicationContext, response.body()!!.data!!)
                        finish()
                    }
                }
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when(requestCode) {
            REQUEST_CODE -> {
                when(resultCode) {
                    Activity.RESULT_OK -> {
                        val e_time = data!!.getStringExtra("end_time")
                        toast("End time : $e_time")
                    }
                }
            }
        }
    }
}























