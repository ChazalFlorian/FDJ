package com.fchazal.fdj.search.domain.interactor

import com.fchazal.fdj.search.domain.model.SearchResult
import com.fchazal.fdj.search.domain.repository.SearchRepository

interface GetSearchUseCase {
    suspend fun getSearchResults(): SearchResult
}

class GetSearchUseCaseImpl(
    val repository: SearchRepository,
) : GetSearchUseCase {
    override suspend fun getSearchResults(): SearchResult = repository.getSearch()
}