package org.sopt24.dshyun0226.soptcomics.repository

import org.koin.dsl.module
import org.sopt24.dshyun0226.soptcomics.domain.repository.UserDataSource

val RepositoryModule = module {
    single { UserRepository(get()) as UserDataSource }
}