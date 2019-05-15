package org.sopt24.dshyun0226.soptcomics.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.signup.SignupActivity
import org.sopt24.dshyun0226.soptcomics.data.source.UserRetrofitApi
import org.sopt24.dshyun0226.soptcomics.data.source.UserRepository

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
    override var presenter: LoginContract.Presenter = LoginPresenter(UserRetrofitApi() ,UserRepository(this), this)

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























