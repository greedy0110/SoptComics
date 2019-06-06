package org.sopt24.dshyun0226.soptcomics.presentation.main

import io.reactivex.disposables.CompositeDisposable
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserDataSource

class MainPresenter(
    private val view: MainContract.View,
    private val api: SoptComicsApi,
    private val userDataSource: UserDataSource): MainContract.Presenter {
    private val compositeDisposable = CompositeDisposable()

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
        api.requestBannerImageUrls()
            .subscribe {
                view.updateBannerImageList(it)
            }.apply { compositeDisposable.add(this) }
    }

    override fun onResume() {
        val isLoggedIn = userDataSource.getUserToken().isNotEmpty()

        view.setToolbarMainActionButton(isLoggedIn)
    }

    override fun onDestroy() {
        compositeDisposable.dispose()
    }
}