package org.sopt24.dshyun0226.soptcomics.main

import org.sopt24.dshyun0226.soptcomics.data.source.UserDataSource

class MainPresenter(private val view: MainContract.View, private val userDataSource: UserDataSource): MainContract.Presenter {
    override fun clickToolbarMainAction() {
        val isLoggedIn = userDataSource.getUserToken().isNotEmpty()

        if (isLoggedIn) {
            userDataSource.clearUserToken()
            view.setToolbarMainActionButton(false) // now logout!
        }
        else {
            view.startLoginActivity()
        }
    }

    override fun onCreate() {
        view.configureMainTab()
        view.configureMainImageTab()
    }

    override fun onResume() {
        val isLoggedIn = userDataSource.getUserToken().isNotEmpty()

        view.setToolbarMainActionButton(isLoggedIn)
    }
}