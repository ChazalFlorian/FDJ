package com.fchazal.fdj.league.data.datasource

import com.fchazal.fdj.league.data.model.LeagueResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LeagueService {

    @GET("api/v1/json/50130162/search_all_teams.php")
    suspend fun getLeagueDetail(@Query("l") query: String): Result<LeagueResponse>
}