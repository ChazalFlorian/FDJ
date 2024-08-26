package com.fchazal.fdj.search.data.model

import androidx.annotation.Keep

@Keep
data class LeagueResponseItem(
    val idLeague: String,
    val strLeague: String,
    val strSport: String,
    val strLeagueAlternate: String?,
)

@Keep
data class LeagueResponse(
    val leagues: List<LeagueResponseItem>,
)
