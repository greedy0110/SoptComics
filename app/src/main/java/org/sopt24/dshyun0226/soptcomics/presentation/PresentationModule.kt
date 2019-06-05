package org.sopt24.dshyun0226.soptcomics.presentation

import org.koin.dsl.module
import org.sopt24.dshyun0226.soptcomics.presentation.login.LoginContract
import org.sopt24.dshyun0226.soptcomics.presentation.main.MainContract
import org.sopt24.dshyun0226.soptcomics.presentation.comics_overview.ComicsOverviewContract
import org.sopt24.dshyun0226.soptcomics.presentation.signup.SignupContract
import org.sopt24.dshyun0226.soptcomics.presentation.login.LoginPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.main.MainPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.comics_overview.ComicsOverviewPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.signup.SignupPresenter

val PresentationModule = module {
    factory { (view: ComicsOverviewContract.View, kind: String) -> ComicsOverviewPresenter(
        view = view,
        api = get(),
        kind = kind
    ) as ComicsOverviewContract.Presenter }

    factory { (view: MainContract.View) -> MainPresenter(
        view = view,
        userDataSource = get()
    ) as MainContract.Presenter }
    factory { (view: SignupContract.View) -> SignupPresenter(
        api = get(),
        view = view
    ) as SignupContract.Presenter }
    factory { (view: LoginContract.View) -> LoginPresenter(
        api = get(),
        userDataSource = get(),
        view = view
    ) as LoginContract.Presenter }
}