package com.fchazal.fdj.inject

import com.fchazal.fdj.search.data.repository.LeagueRepositoryImpl
import com.fchazal.fdj.search.domain.repository.LeagueRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<LeagueRepository> {
        LeagueRepositoryImpl(
            dataSource = get()
        )
    }
}