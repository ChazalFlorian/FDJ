package com.fchazal.fdj.league.domain.repository

import com.fchazal.fdj.league.domain.model.LeagueResult

interface LeagueRepository {

    suspend fun getLeagues(query: String): LeagueResult
}