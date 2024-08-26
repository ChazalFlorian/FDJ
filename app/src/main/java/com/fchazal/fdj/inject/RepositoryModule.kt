package com.fchazal.fdj.inject

import com.fchazal.fdj.search.data.repository.SearchRepositoryImpl
import com.fchazal.fdj.search.domain.repository.SearchRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(
            dataSource = get()
        )
    }
}