package org.sopt24.dshyun0226.soptcomics.presentation.login

import io.reactivex.disposables.CompositeDisposable
import org.sopt24.dshyun0226.soptcomics.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.repository.UserDataSource

class LoginPresenter(
    private val api: SoptComicsApi,
    private val userDataSource: UserDataSource,
    private val view: LoginContract.View
): LoginContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

    override fun login(id: String, pw: String) {
        when {
            id.isEmpty() -> view.focusEditLoginID()
            pw.isEmpty() -> view.focusEditLoginPW()
            else -> {
                api.requestToken(id, pw)
                    .subscribe {
                        userDataSource.setUserToken(id)
                        view.finish()
                    }.apply { compositeDisposable.add(this) }
            }
        }
    }

    override fun openSignup() {
        view.openSignup()
    }

    override fun onDestory() {
        compositeDisposable.dispose()
    }
}
