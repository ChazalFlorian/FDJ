package com.fchazal.fdj.search.data.datasource

import com.fchazal.fdj.search.data.model.LeagueResponse

interface SearchDataSource {

    suspend fun getLeagues(): Result<LeagueResponse>
}

class SearchDataSourceImpl(
    private val leagueService: LeagueService,
) : SearchDataSource {
    override suspend fun getLeagues(): Result<LeagueResponse> {
        return leagueService.getLeague()
    }
}