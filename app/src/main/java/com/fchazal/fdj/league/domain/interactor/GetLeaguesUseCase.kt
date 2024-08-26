package com.fchazal.fdj.league.domain.interactor

import com.fchazal.fdj.league.domain.model.LeagueResult
import com.fchazal.fdj.league.domain.repository.LeagueRepository

interface GetLeaguesUseCase {
    suspend fun getLeagues(query: String): LeagueResult
}

class GetLeaguesUseCaseImpl(
    private val repository: LeagueRepository,
) : GetLeaguesUseCase {
    override suspend fun getLeagues(query: String): LeagueResult = repository.getLeagues(query)
}