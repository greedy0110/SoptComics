package org.sopt24.dshyun0226.soptcomics.api

import org.koin.dsl.module
import org.sopt24.dshyun0226.soptcomics.repository.SoptComicsApi

val ApiModule = module {
    single { SoptComicsRetrofitApi() as SoptComicsApi }
}