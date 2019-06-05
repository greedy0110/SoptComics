package org.sopt24.dshyun0226.soptcomics.presentation.signup

import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi

class SignupPresenter(
    private val view : SignupContract.View,
    private val api: SoptComicsApi
) : SignupContract.Presenter {
    override fun signup(name: String, id: String, pw: String) {
        when {
            name.isEmpty() -> view.focusEditSignupName()
            id.isEmpty() -> view.focusEditSignupID()
            pw.isEmpty() -> view.focusEditSignupPW()
            else -> {
                api.requestSignup(name, id, pw)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread()) -> 여기에서 android scheduler 를 mocking 할 수 없다!!
                    .subscribe {
                        if (it.status == 201)
                            view.finish()
                    }
            }
        }
    }
}