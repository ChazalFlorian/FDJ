package com.fchazal.fdj.league.domain.model

import com.fchazal.fdj.league.presentation.model.LeagueItemBlockUI

sealed class LeagueResult {
    data class Success(val searchList: List<LeagueItemBlockUI>) : LeagueResult()
    data class Error(val error: String) : LeagueResult()
}