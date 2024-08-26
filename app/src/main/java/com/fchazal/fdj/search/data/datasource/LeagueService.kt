package com.fchazal.fdj.search.data.datasource

import com.fchazal.fdj.search.data.model.LeagueResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface LeagueService {

    @GET("api/v1/json/50130162/all_leagues.php")
    suspend fun getLeague(): Result<LeagueResponse>
}