package com.fchazal.fdj.search.domain.repository

import com.fchazal.fdj.search.domain.model.LeagueResult

interface LeagueRepository {
    suspend fun getLeagues(): LeagueResult
}
