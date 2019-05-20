package org.sopt24.dshyun0226.soptcomics.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.ParametersDefinition
import org.koin.core.parameter.parametersOf
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

    override val presenter: LoginContract.Presenter by inject { parametersOf(this) }

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























