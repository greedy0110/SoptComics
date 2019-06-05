package org.sopt24.dshyun0226.soptcomics.presentation.main

import org.sopt24.dshyun0226.soptcomics.presentation.view.BaseView

interface MainContract {
    interface View: BaseView<Presenter> {
        fun startLoginActivity()
        fun configureMainTab()
        fun setToolbarMainActionButton(isLoggedIn: Boolean)
        fun updateBannerImageList(bannerImgUrls: List<String>)
    }

    interface Presenter {
        fun clickToolbarMainAction()
        fun onCreate()
        fun onResume()
    }
}