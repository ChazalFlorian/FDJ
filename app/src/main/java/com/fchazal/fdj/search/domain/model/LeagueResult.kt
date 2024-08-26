package com.fchazal.fdj.search.domain.model

import com.fchazal.fdj.search.presentation.model.LeagueBlockUI

sealed class LeagueResult {
    data class Success(val leagueList: List<LeagueBlockUI>) : LeagueResult()
    data class Error(val error: String) : LeagueResult()
}