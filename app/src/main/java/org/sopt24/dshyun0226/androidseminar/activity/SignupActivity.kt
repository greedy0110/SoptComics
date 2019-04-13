package org.sopt24.dshyun0226.androidseminar.activity

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_signup.*
import org.sopt24.dshyun0226.androidseminar.R
import java.text.SimpleDateFormat
import java.util.*

class SignupActivity : AppCompatActivity() {

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
                finish()
            }
        }
    }

    fun postSignupResponse(u_id: String, u_pw: String, u_nmae: String){
        val simpleDateFormat = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val e_time = simpleDateFormat.format(Date())

        val intent = Intent()
        intent.putExtra("end_time", e_time)
        setResult(Activity.RESULT_OK, intent) // 부모에게 intent 를 전달

        finish()
    }
}
