package com.fchazal.fdj.search.domain.interactor

import com.fchazal.fdj.search.domain.model.SearchResult
import com.fchazal.fdj.search.presentation.model.SearchItemBlockUI

interface FilterSearchUseCase {
    suspend fun filterSearch(query: String, searchResults: List<SearchItemBlockUI>): SearchResult
}

class FilterSearchUseCaseImpl() : FilterSearchUseCase {
    override suspend fun filterSearch(query: String, searchResults: List<SearchItemBlockUI>): SearchResult {
        return SearchResult.Success(searchResults.filter { it.league.contains(query) })
    }
}