package com.fchazal.fdj.league.data.repository

import com.fchazal.fdj.league.data.datasource.LeagueDataSource
import com.fchazal.fdj.league.data.dummyLeagueResponse
import com.fchazal.fdj.league.data.dummyLeagueResponseSuccess
import com.fchazal.fdj.league.domain.model.LeagueResult
import com.fchazal.fdj.league.domain.repository.LeagueRepository
import com.fchazal.fdj.util.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LeagueRepositoryImplTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var dataSource: LeagueDataSource
    private lateinit var leagueRepository: LeagueRepository
    private val errorMessage = "test"
    private val error = Throwable(errorMessage)

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        leagueRepository = LeagueRepositoryImpl(dataSource)
    }

    @Test
    fun `getSearch - onSuccess - should return Success`() = runTest {
        //given
        coEvery { dataSource.getLeagues("") } returns Result.success(dummyLeagueResponseSuccess)

        //when
        leagueRepository.getLeagues("")

        //then
        assertEquals(
            leagueRepository.getLeagues(""), dummyLeagueResponse
        )
    }

    @Test
    fun `getSearch - onFailure - should return Failure`() = runTest {
        //given
        coEvery { dataSource.getLeagues("") } returns Result.failure(error)

        //when
        leagueRepository.getLeagues("")

        //then
        assertEquals(
            leagueRepository.getLeagues(""), LeagueResult.Error(errorMessage)
        )
    }
}