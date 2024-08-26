package com.fchazal.fdj.search.data.model

import androidx.annotation.Keep

@Keep
data class SearchResponseItem(
    val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String?,
)

@Keep
data class SearchResponse(
    val searchItems: List<SearchResponseItem>,
)
