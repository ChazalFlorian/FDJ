package com.fchazal.fdj.search.domain.interactor

import com.fchazal.fdj.search.domain.model.LeagueResult
import com.fchazal.fdj.search.domain.repository.LeagueRepository

interface GetLeagueUseCase {
    suspend fun getLeagues(): LeagueResult
}

class GetLeagueUseCaseImpl(
    val repository: LeagueRepository,
) : GetLeagueUseCase {
    override suspend fun getLeagues(): LeagueResult = repository.getLeagues()
}