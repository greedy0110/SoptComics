package org.sopt24.dshyun0226.androidseminar

import android.app.Application
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import org.sopt24.dshyun0226.androidseminar.network.NetworkService
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