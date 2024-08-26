package com.fchazal.fdj.inject

import com.fchazal.fdj.search.data.datasource.SearchDataSource
import com.fchazal.fdj.search.data.datasource.SearchDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<SearchDataSource> {
        SearchDataSourceImpl(
            leagueService = get()
        )
    }
}