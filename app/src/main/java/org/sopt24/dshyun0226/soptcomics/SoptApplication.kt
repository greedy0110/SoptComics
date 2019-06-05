package org.sopt24.dshyun0226.soptcomics

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.sopt24.dshyun0226.soptcomics.api.ApiModule
import org.sopt24.dshyun0226.soptcomics.presentation.PresentationModule
import org.sopt24.dshyun0226.soptcomics.repository.RepositoryModule

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