package org.sopt24.dshyun0226.soptcomics

import android.app.Application
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.sopt24.dshyun0226.soptcomics.api.ApiModule
import org.sopt24.dshyun0226.soptcomics.domain.repository.SoptComicsApi
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserDataSource
import org.sopt24.dshyun0226.soptcomics.repository.UserRepository
import org.sopt24.dshyun0226.soptcomics.api.SoptComicsRetrofitApi
import org.sopt24.dshyun0226.soptcomics.presentation.contract.LoginContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.LoginPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.contract.MainContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.MainPresenter
import org.sopt24.dshyun0226.soptcomics.api.SoptComicsRetrofitApiInterface
import org.sopt24.dshyun0226.soptcomics.presentation.PresentationModule
import org.sopt24.dshyun0226.soptcomics.presentation.contract.ProductContract
import org.sopt24.dshyun0226.soptcomics.presentation.contract.SignupContract
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.ProductPresenter
import org.sopt24.dshyun0226.soptcomics.presentation.presenter.SignupPresenter
import org.sopt24.dshyun0226.soptcomics.repository.RepositoryModule
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SoptApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SoptApplication)
            modules(listOf(
                ApiModule,
                PresentationModule,
                RepositoryModule
            ))
        }
    }
}