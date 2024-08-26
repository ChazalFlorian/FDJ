package com.fchazal.fdj.search.data.repository

import com.fchazal.fdj.search.data.datasource.SearchDataSource
import com.fchazal.fdj.search.data.model.LeagueResponseItem
import com.fchazal.fdj.search.domain.model.LeagueResult
import com.fchazal.fdj.search.domain.repository.LeagueRepository
import com.fchazal.fdj.search.presentation.model.LeagueBlockUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeagueRepositoryImpl(
    val dataSource: SearchDataSource,
) : LeagueRepository {

    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    override suspend fun getLeagues(): LeagueResult = withContext(dispatcher) {
        dataSource.getLeagues().fold(
            onSuccess = {
                LeagueResult.Success(
                    it.leagues.toListLeagueBlockUI()
                )
            },
            onFailure = {
                LeagueResult.Error(it.localizedMessage ?: "")
            }
        )
    }

    fun List<LeagueResponseItem>.toListLeagueBlockUI(): List<LeagueBlockUI> = map {
        it.toLeagueBlockUI()
    }

    private fun LeagueResponseItem.toLeagueBlockUI(): LeagueBlockUI = LeagueBlockUI(
        id = idLeague,
        league = strLeague,
        sport = strSport,
        leagueAlternate = strLeagueAlternate ?: ""
    )
}