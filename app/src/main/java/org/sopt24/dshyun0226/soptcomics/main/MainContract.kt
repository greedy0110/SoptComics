package org.sopt24.dshyun0226.soptcomics.main

import org.sopt24.dshyun0226.soptcomics.BaseView

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