package org.sopt24.dshyun0226.soptcomics.presentation.login

import org.sopt24.dshyun0226.soptcomics.presentation.BaseView

interface LoginContract {
    interface Presenter {
        fun login(id: String, pw: String)
        fun openSignup()
        fun onDestory()
    }

    interface View : BaseView<Presenter> {
        fun focusEditLoginID()
        fun focusEditLoginPW()
        fun finish()
        fun openSignup()
    }
}