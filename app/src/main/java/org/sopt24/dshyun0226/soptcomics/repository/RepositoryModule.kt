package org.sopt24.dshyun0226.soptcomics.repository

import org.koin.dsl.module

val RepositoryModule = module {
    single { UserRepository(get()) as UserDataSource }
}