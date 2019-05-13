package org.sopt24.dshyun0226.androidseminar.login

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import org.json.JSONObject
import org.sopt24.dshyun0226.androidseminar.R
import org.sopt24.dshyun0226.androidseminar.SoptApplication
import org.sopt24.dshyun0226.androidseminar.activity.SignupActivity
import org.sopt24.dshyun0226.androidseminar.data.source.TokenLocalApi
import org.sopt24.dshyun0226.androidseminar.data.source.TokenRetrofitApi
import org.sopt24.dshyun0226.androidseminar.data.source.UserRepository
import org.sopt24.dshyun0226.androidseminar.db.SharedPreferenceController
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
import org.sopt24.dshyun0226.androidseminar.network.post.PostLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity(), LoginContract.View {
    override fun focusEditLoginID() {
        edtLoginID.requestFocus()
    }

    override fun focusEditLoginPW() {
        edtLoginPW.requestFocus()
    }

    override fun openSignup() {
        startActivity<SignupActivity>()
    }

    // TODO 사실은 UserRepository 는 어디서 접근해도 하나의 객체에서 접근해야하는 object 이다.
    override var presenter: LoginContract.Presenter = LoginPresenter(TokenRetrofitApi() ,UserRepository(this), this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLoginSubmit.setOnClickListener {
            val login_u_id = edtLoginID.text.toString()
            val login_u_pw: String = edtLoginPW.text.toString()
            presenter.login(login_u_id, login_u_pw)
        }

        txtLoginSignup.setOnClickListener{
            presenter.openSignup()
        }

    }
}























