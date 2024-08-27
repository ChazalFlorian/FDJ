package com.fchazal.fdj.search.data.repository

import com.fchazal.fdj.search.data.datasource.SearchDataSource
import com.fchazal.fdj.search.data.model.SearchResponseItem
import com.fchazal.fdj.search.domain.model.SearchResult
import com.fchazal.fdj.search.domain.repository.SearchRepository
import com.fchazal.fdj.search.presentation.model.SearchItemBlockUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SearchRepositoryImpl(
    val dataSource: SearchDataSource,
) : SearchRepository {

    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    override suspend fun getSearch(): SearchResult = withContext(dispatcher) {
        dataSource.getSearchResults().fold(
            onSuccess = {
                SearchResult.Success(
                    it.leagues.toSearchItemListBlockUI()
                )
            },
            onFailure = {
                SearchResult.Error(it.localizedMessage ?: "")
            }
        )
    }

    private fun List<SearchResponseItem>.toSearchItemListBlockUI(): List<SearchItemBlockUI> = map {
        it.toSearchItemBlockUI()
    }

    private fun SearchResponseItem.toSearchItemBlockUI(): SearchItemBlockUI = SearchItemBlockUI(
        id = idLeague,
        league = strLeague,
        sport = strSport,
        leagueAlternate = strLeagueAlternate ?: ""
    )
}