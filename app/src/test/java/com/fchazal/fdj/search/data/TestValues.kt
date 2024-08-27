package com.fchazal.fdj.search.data

import com.fchazal.fdj.search.SearchResultState
import com.fchazal.fdj.search.data.model.SearchResponse
import com.fchazal.fdj.search.data.model.SearchResponseItem
import com.fchazal.fdj.search.domain.model.SearchResult
import com.fchazal.fdj.search.presentation.model.SearchItemBlockUI

internal val dummySearchResultItem = listOf(
    SearchResponseItem(
        idLeague = "test",
        strLeague = "filter",
        strLeagueAlternate = "",
        strSport = ""
    ),
    SearchResponseItem(
        idLeague = "test",
        strLeague = "kebab",
        strLeagueAlternate = "",
        strSport = ""
    ),
    SearchResponseItem(
        idLeague = "test",
        strLeague = "shawarma",
        strLeagueAlternate = "",
        strSport = ""
    )
)

internal val dummyFilteredSearchResultItem = listOf(
    SearchResponseItem(
        idLeague = "test",
        strLeague = "shawarma",
        strLeagueAlternate = "",
        strSport = ""
    )
)

internal val dummySearchResponse = SearchResponse(
    leagues = dummySearchResultItem
)

internal val dummySuccessResponse = SearchResult.Success(
    listOf(
        SearchItemBlockUI(
            id = "test",
            league = "filter",
            leagueAlternate = "",
            sport = ""
        ),
        SearchItemBlockUI(
            id = "test",
            league = "kebab",
            leagueAlternate = "",
            sport = ""
        ),
        SearchItemBlockUI(
            id = "test",
            league = "shawarma",
            leagueAlternate = "",
            sport = ""
        ),
    )
)

internal val dummySuccessState = SearchResultState.Success(
    listOf(
        SearchItemBlockUI(
            id = "test",
            league = "filter",
            leagueAlternate = "",
            sport = ""
        ),
        SearchItemBlockUI(
            id = "test",
            league = "kebab",
            leagueAlternate = "",
            sport = ""
        ),
        SearchItemBlockUI(
            id = "test",
            league = "shawarma",
            leagueAlternate = "",
            sport = ""
        ),
    )
)

internal val dummyFiltered = SearchResult.Success(listOf(
    SearchItemBlockUI(
        id = "test",
        league = "shawarma",
        leagueAlternate = "",
        sport = ""
    )
))