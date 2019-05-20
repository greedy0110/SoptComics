package org.sopt24.dshyun0226.soptcomics.signup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_signup.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf
import org.sopt24.dshyun0226.soptcomics.R
import org.sopt24.dshyun0226.soptcomics.data.source.UserRetrofitApi

class SignupActivity : AppCompatActivity(), SignupContract.View {

    override val presenter: SignupContract.Presenter by inject { parametersOf(this) }

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
