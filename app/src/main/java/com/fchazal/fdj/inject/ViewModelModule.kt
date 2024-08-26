package com.fchazal.fdj.inject

import com.fchazal.fdj.league.LeagueViewModel
import com.fchazal.fdj.search.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel {
        SearchViewModel(
            getSearchUseCase = get(),
            filterSearchUseCase = get()
        )
    }
    viewModel {
        LeagueViewModel(
            useCase = get()
        )
    }
}