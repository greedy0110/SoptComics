package org.sopt24.dshyun0226.soptcomics.signup

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signup.*
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.data.source.UserRetrofitApi

class SignupActivity : AppCompatActivity(), SignupContract.View {

    override var presenter: SignupContract.Presenter = SignupPresenter(this, UserRetrofitApi())

    override fun focusEditSignupName() {
        edtSignupName.requestFocus()
    }

    override fun focusEditSignupID() {
        edtSignupID.requestFocus()
    }

    override fun focusEditSignupPW() {
        edtSignupPW.requestFocus()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btnSignupSubmit.setOnClickListener {
            val name: String = edtSignupName.text.toString()
            val id = edtSignupID.text.toString()
            val pw: String = edtSignupPW.text.toString()
            presenter.signup(name, id, pw)
        }
    }
}
