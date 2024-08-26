package com.fchazal.fdj.search.data.datasource

import com.fchazal.fdj.search.data.model.SearchResponse

interface SearchDataSource {

    suspend fun getSearchResults(): Result<SearchResponse>
}

class SearchDataSourceImpl(
    private val searchService: SearchService,
) : SearchDataSource {
    override suspend fun getSearchResults(): Result<SearchResponse> {
        return searchService.search()
    }
}