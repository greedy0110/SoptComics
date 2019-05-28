package org.sopt24.dshyun0226.soptcomics.presentation.contract

import org.sopt24.dshyun0226.soptcomics.presentation.view.BaseView

interface MainContract {
    interface View: BaseView<Presenter> {
        fun startLoginActivity()
        fun configureMainTab()
        fun configureMainImageTab()
        fun setToolbarMainActionButton(isLoggedIn: Boolean)
    }

    interface Presenter {
        fun clickToolbarMainAction()
        fun onCreate()
        fun onResume()
    }
}