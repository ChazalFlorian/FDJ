package com.fchazal.fdj.search.data.datasource

import com.fchazal.fdj.search.data.model.SearchResponse
import retrofit2.http.GET

interface SearchService {

    @GET("api/v1/json/50130162/all_leagues.php")
    suspend fun search(): Result<SearchResponse>
}