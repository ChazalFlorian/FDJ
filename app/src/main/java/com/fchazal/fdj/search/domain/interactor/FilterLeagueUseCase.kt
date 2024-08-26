package com.fchazal.fdj.search.domain.interactor

import com.fchazal.fdj.search.domain.model.LeagueResult
import com.fchazal.fdj.search.presentation.model.LeagueBlockUI

interface FilterLeagueUseCase {
    suspend fun filterLeagues(query: String, leagues: List<LeagueBlockUI>): LeagueResult
}

class FilterLeagueUseCaseImpl() : FilterLeagueUseCase {
    override suspend fun filterLeagues(query: String, leagues: List<LeagueBlockUI>): LeagueResult {
        return LeagueResult.Success(leagues.filter { it.league.contains(query) })
    }
}