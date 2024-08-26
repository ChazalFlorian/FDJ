package com.fchazal.fdj.search.domain.repository

import com.fchazal.fdj.search.domain.model.SearchResult

interface SearchRepository {
    suspend fun getSearch(): SearchResult
}
