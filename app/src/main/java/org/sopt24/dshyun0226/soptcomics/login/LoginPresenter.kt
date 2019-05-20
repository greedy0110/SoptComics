package org.sopt24.dshyun0226.soptcomics.login

import org.sopt24.dshyun0226.soptcomics.data.source.UserApi
import org.sopt24.dshyun0226.soptcomics.data.source.UserDataSource

class LoginPresenter(
    private val userApi: UserApi,
    private val userDataSource: UserDataSource,
    private val view: LoginContract.View
): LoginContract.Presenter {
    override fun login(id: String, pw: String) {
        when {
            id.isEmpty() -> view.focusEditLoginID()
            pw.isEmpty() -> view.focusEditLoginPW()
            else -> {
                userApi.requestToken(id, pw)
                    .subscribe {
                        userDataSource.setUserToken(id)
                        view.finish()
                    }
            }
        }
    }

    override fun openSignup() {
        view.openSignup()
    }
}
