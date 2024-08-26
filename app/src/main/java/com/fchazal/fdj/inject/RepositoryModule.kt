package com.fchazal.fdj.inject

import com.fchazal.fdj.league.data.repository.LeagueRepositoryImpl
import com.fchazal.fdj.league.domain.repository.LeagueRepository
import com.fchazal.fdj.search.data.repository.SearchRepositoryImpl
import com.fchazal.fdj.search.domain.repository.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(
            dataSource = get()
        )
    }

    single<LeagueRepository> {
        LeagueRepositoryImpl(
            dataSource = get()
        )
    }
}