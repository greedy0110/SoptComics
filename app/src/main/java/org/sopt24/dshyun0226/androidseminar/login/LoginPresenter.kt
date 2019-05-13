package org.sopt24.dshyun0226.androidseminar.login

import org.sopt24.dshyun0226.androidseminar.data.source.TokenApi
import org.sopt24.dshyun0226.androidseminar.data.source.UserDataSource

class LoginPresenter(
    private val tokenApi: TokenApi,
    private val userDataSource: UserDataSource,
    private val loginView: LoginContract.View
): LoginContract.Presenter {
    override fun login(id: String, pw: String) {
        when {
            id.isEmpty() -> loginView.focusEditLoginID()
            pw.isEmpty() -> loginView.focusEditLoginPW()
            else -> {
                tokenApi.getToken(id, pw)
                    .subscribe {
                        userDataSource.setUserToken(id)
                        loginView.finish()
                    }
            }
        }
    }

    override fun openSignup() {
        loginView.openSignup()
    }
}
