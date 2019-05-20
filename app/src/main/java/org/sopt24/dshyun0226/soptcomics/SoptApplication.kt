package org.sopt24.dshyun0226.soptcomics

import android.app.Application
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module
import org.sopt24.dshyun0226.soptcomics.data.source.UserApi
import org.sopt24.dshyun0226.soptcomics.data.source.UserDataSource
import org.sopt24.dshyun0226.soptcomics.data.source.UserRepository
import org.sopt24.dshyun0226.soptcomics.data.source.UserRetrofitApi
import org.sopt24.dshyun0226.soptcomics.login.LoginContract
import org.sopt24.dshyun0226.soptcomics.login.LoginPresenter
import org.sopt24.dshyun0226.soptcomics.main.MainContract
import org.sopt24.dshyun0226.soptcomics.main.MainPresenter
import org.sopt24.dshyun0226.soptcomics.network.NetworkService
import org.sopt24.dshyun0226.soptcomics.signup.SignupContract
import org.sopt24.dshyun0226.soptcomics.signup.SignupPresenter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SoptApplication: Application() {
    private val baseURL = "http://hyunjkluz.ml:2424/"
    lateinit var networkService: NetworkService

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

        networkService = retrofit.create(NetworkService::class.java)
    }
}

val module = module {
    factory { (view: MainContract.View) -> MainPresenter(view = view, userDataSource = get()) as MainContract.Presenter }
    factory { (view: SignupContract.View) -> SignupPresenter(userApi = get(), view = view) as SignupContract.Presenter }
    factory { (view: LoginContract.View) -> LoginPresenter(userApi = get(), userDataSource = get() ,view = view) as LoginContract.Presenter }

    single { UserRetrofitApi() as UserApi }
    single { UserRepository(get()) as UserDataSource }
}