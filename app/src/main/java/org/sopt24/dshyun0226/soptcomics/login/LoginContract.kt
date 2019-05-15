package org.sopt24.dshyun0226.soptcomics.login

import org.sopt24.dshyun0226.soptcomics.BaseView

interface LoginContract {
    interface Presenter {
        fun login(id: String, pw: String)
        fun openSignup()
    }

    interface View : BaseView<Presenter> {
        fun focusEditLoginID()
        fun focusEditLoginPW()
        fun finish()
        fun openSignup()
    }
}