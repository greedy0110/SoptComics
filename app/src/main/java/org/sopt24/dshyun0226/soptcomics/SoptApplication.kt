package org.sopt24.dshyun0226.soptcomics

import android.app.Application
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserApi
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserDataSource
import org.sopt24.dshyun0226.soptcomics.data.repository.UserRepository
import org.sopt24.dshyun0226.soptcomics.api.UserRetrofitApi
import org.sopt24.dshyun0226.soptcomics.presentation.contract.LoginContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.LoginPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.contract.MainContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.MainPresenter
import org.sopt24.dshyun0226.soptcomics.api.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.presentation.contract.SignupContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.SignupPresenter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SoptApplication: Application() {
    private val baseURL = "http://hyunjkluz.ml:2424/"
    lateinit var networkService: SoptComicsApi

    companion object {
        lateinit var instance: SoptApplication
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()

        startKoin {
            androidContext(this@SoptApplication)
            modules(module)
        }
    }

    private fun buildNetwork() {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()

        networkService = retrofit.create(SoptComicsApi::class.java)
    }
}

val module = module {
    factory { (view: MainContract.View) -> MainPresenter(
        view = view,
        userDataSource = get()
    ) as MainContract.Presenter }
    factory { (view: SignupContract.View) -> SignupPresenter(
        userApi = get(),
        view = view
    ) as SignupContract.Presenter }
    factory { (view: LoginContract.View) -> LoginPresenter(
        userApi = get(),
        userDataSource = get(),
        view = view
    ) as LoginContract.Presenter }

    single { UserRetrofitApi() as UserApi }
    single { UserRepository(get()) as UserDataSource }
}