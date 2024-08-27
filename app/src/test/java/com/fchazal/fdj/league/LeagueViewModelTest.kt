package com.fchazal.fdj.league

import com.fchazal.fdj.league.data.dummyLeagueResponse
import com.fchazal.fdj.league.data.dummySuccessState
import com.fchazal.fdj.league.domain.interactor.GetLeaguesUseCase
import com.fchazal.fdj.league.domain.model.LeagueResult
import com.fchazal.fdj.util.CoroutineTestRule
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class LeagueViewModelTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    private lateinit var useCase: GetLeaguesUseCase
    private lateinit var viewModel: LeagueViewModel

    @Before
    fun setUp() {
        init(this)
        viewModel = LeagueViewModel(useCase)
    }

    @Test
    fun `getLeagues - on Success Receive - should return success state`() = runTest {
        //given
        coEvery { useCase.getLeagues("") } returns dummyLeagueResponse

        //when
        viewModel.getLeagues("")

        //then
        assertEquals(
            (viewModel.state.value as LeagueResultState.Success).searchResults,
            dummySuccessState.searchResults
        )
    }

    @Test
    fun `getLeagues - on Failure Receive - should return failure state`() = runTest {
        //given
        coEvery { useCase.getLeagues("") } returns LeagueResult.Error("")

        //when
        viewModel.getLeagues("")

        //then
        assertEquals(
            (viewModel.state.value as LeagueResultState.Error).exception,
            ""
        )
    }
}