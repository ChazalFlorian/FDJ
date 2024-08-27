package com.fchazal.fdj.league.data.repository

import com.fchazal.fdj.league.data.datasource.LeagueDataSource
import com.fchazal.fdj.league.data.model.TeamResponse
import com.fchazal.fdj.league.domain.model.LeagueResult
import com.fchazal.fdj.league.domain.repository.LeagueRepository
import com.fchazal.fdj.league.presentation.model.LeagueItemBlockUI
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LeagueRepositoryImpl(
    private val dataSource: LeagueDataSource,
) : LeagueRepository {

    val dispatcher: CoroutineDispatcher = Dispatchers.IO
    override suspend fun getLeagues(query: String): LeagueResult = withContext(dispatcher) {
        dataSource.getLeagues(query).fold(
            onSuccess = {
                LeagueResult.Success(
                    it.teams.toLeagueItemListBlockUI().filterResponse()
                )
            },
            onFailure = {
                LeagueResult.Error(it.localizedMessage ?: "")
            }
        )
    }

    private fun List<TeamResponse>.toLeagueItemListBlockUI() = map {
        it.toLeagueItemBlockUI()
    }

    private fun TeamResponse.toLeagueItemBlockUI() = LeagueItemBlockUI(
        logoUrl = strLogo?: "",
        description = strDescriptionFR ?: ""
    )

    private fun List<LeagueItemBlockUI>.filterResponse(): List<LeagueItemBlockUI> =
        sortedBy { it.description }
            .asReversed()
            .filterIndexed { index, _ ->
                index % 2 == 0
            }
}
