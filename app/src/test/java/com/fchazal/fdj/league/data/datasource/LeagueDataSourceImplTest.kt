package com.fchazal.fdj.league.data.datasource

import com.fchazal.fdj.league.data.dummyLeagueResponseSuccess
import com.fchazal.fdj.util.CoroutineTestRule
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LeagueDataSourceImplTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var leagueService: LeagueService
    private lateinit var leagueDataSource: LeagueDataSource
    private val error = Throwable()

    @Before
    fun setUp() {
        init(this)
        leagueDataSource = LeagueDataSourceImpl(leagueService)
    }

    @Test
    fun `getLeagues - should return result of league response`() = runTest {
        //Given
        coEvery { leagueService.getLeagueDetail("") } returns Result.success(
            dummyLeagueResponseSuccess
        )
        //when
        leagueDataSource.getLeagues("")
        //then
        assert(leagueDataSource.getLeagues("").isSuccess)
        assertEquals(leagueDataSource.getLeagues("").getOrNull(), dummyLeagueResponseSuccess)
    }

    @Test
    fun `getLeagues - should return failure if failure response`() = runTest {
        //Given
        coEvery { leagueService.getLeagueDetail("") } returns Result.failure(
            error
        )
        //when
        leagueDataSource.getLeagues("")
        //then
        assert(leagueDataSource.getLeagues("").isFailure)
        assertEquals(leagueDataSource.getLeagues("").exceptionOrNull(), error)
    }
}