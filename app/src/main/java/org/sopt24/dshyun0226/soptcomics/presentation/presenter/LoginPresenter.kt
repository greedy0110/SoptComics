package org.sopt24.dshyun0226.soptcomics.presentation.presenter

import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserDataSource
import org.sopt24.dshyun0226.soptcomics.presentation.contract.LoginContract

class LoginPresenter(
    private val api: SoptComicsApi,
    private val userDataSource: UserDataSource,
    private val view: LoginContract.View
): LoginContract.Presenter {
    override fun login(id: String, pw: String) {
        when {
            id.isEmpty() -> view.focusEditLoginID()
            pw.isEmpty() -> view.focusEditLoginPW()
            else -> {
                api.requestToken(id, pw)
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
