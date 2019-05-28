package org.sopt24.dshyun0226.soptcomics.presentation

import org.koin.dsl.module
import org.sopt24.dshyun0226.soptcomics.presentation.contract.LoginContract
import org.sopt24.dshyun0226.soptcomics.presentation.contract.MainContract
import org.sopt24.dshyun0226.soptcomics.presentation.contract.ProductContract
import org.sopt24.dshyun0226.soptcomics.presentation.contract.SignupContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.LoginPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.MainPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.ProductPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.SignupPresenter

val PresentationModule = module {
    factory { (view: ProductContract.View, kind: String) -> ProductPresenter(
        view = view,
        api = get(),
        kind = kind
    ) as ProductContract.Presenter }

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