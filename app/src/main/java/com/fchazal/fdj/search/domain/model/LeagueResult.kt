package com.fchazal.fdj.search.domain.model

import com.fchazal.fdj.search.presentation.model.LeagueBlocUI

sealed class LeagueResult {
    data class Success(val leagueList: List<LeagueBlocUI>) : LeagueResult()
    data class Error(val error: String) : LeagueResult()
}