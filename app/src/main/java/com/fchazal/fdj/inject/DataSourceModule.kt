package com.fchazal.fdj.inject

import com.fchazal.fdj.league.data.datasource.LeagueDataSource
import com.fchazal.fdj.league.data.datasource.LeagueDataSourceImpl
import com.fchazal.fdj.search.data.datasource.SearchDataSource
import com.fchazal.fdj.search.data.datasource.SearchDataSourceImpl
import org.koin.dsl.module

val dataSourceModule = module {
    single<SearchDataSource> {
        SearchDataSourceImpl(
            searchService = get()
        )
    }
    single<LeagueDataSource> {
        LeagueDataSourceImpl(
            service = get()
        )
    }
}