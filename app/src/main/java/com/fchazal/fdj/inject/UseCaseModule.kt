package com.fchazal.fdj.inject

import com.fchazal.fdj.search.domain.interactor.FilterLeagueUseCase
import com.fchazal.fdj.search.domain.interactor.FilterLeagueUseCaseImpl
import com.fchazal.fdj.search.domain.interactor.GetLeagueUseCase
import com.fchazal.fdj.search.domain.interactor.GetLeagueUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetLeagueUseCase> {
        GetLeagueUseCaseImpl(
            repository = get()
        )
    }
    factory<FilterLeagueUseCase> {
        FilterLeagueUseCaseImpl()
    }
}