package com.fchazal.fdj.inject

import com.fchazal.fdj.search.domain.interactor.FilterSearchUseCase
import com.fchazal.fdj.search.domain.interactor.FilterSearchUseCaseImpl
import com.fchazal.fdj.search.domain.interactor.GetSearchUseCase
import com.fchazal.fdj.search.domain.interactor.GetSearchUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<GetSearchUseCase> {
        GetSearchUseCaseImpl(
            repository = get()
        )
    }
    factory<FilterSearchUseCase> {
        FilterSearchUseCaseImpl()
    }
}