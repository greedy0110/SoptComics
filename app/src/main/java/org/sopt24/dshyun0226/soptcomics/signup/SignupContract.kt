package org.sopt24.dshyun0226.soptcomics.signup

import org.sopt24.dshyun0226.soptcomics.BaseView

interface SignupContract {
    interface View : BaseView<Presenter> {
        fun focusEditSignupName()
        fun focusEditSignupID()
        fun focusEditSignupPW()
        fun finish()
    }

    interface Presenter {
        fun signup(name: String, id: String, pw: String)
    }
}