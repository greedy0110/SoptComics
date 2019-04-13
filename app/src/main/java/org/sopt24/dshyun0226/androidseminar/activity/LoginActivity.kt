package org.sopt24.dshyun0226.androidseminar.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivityForResult
import org.jetbrains.anko.toast
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.db.SharedPreferenceController
import java.text.SimpleDateFormat
import java.util.*

class LoginActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1000

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

    fun postLoginResponse(u_id: String, u_pw: String){
        // Request Login
        SharedPreferenceController.setUserID(this, u_id)

        finish()
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























