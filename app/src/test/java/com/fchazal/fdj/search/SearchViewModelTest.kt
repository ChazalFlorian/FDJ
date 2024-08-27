package com.fchazal.fdj.search

import com.fchazal.fdj.search.data.dummySuccessResponse
import com.fchazal.fdj.search.data.dummySuccessState
import com.fchazal.fdj.search.domain.interactor.FilterSearchUseCase
import com.fchazal.fdj.search.domain.interactor.GetSearchUseCase
import com.fchazal.fdj.search.domain.model.SearchResult
import com.fchazal.fdj.util.CoroutineTestRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    private lateinit var getUseCase: GetSearchUseCase

    @MockK
    private lateinit var filterUseCase: FilterSearchUseCase
    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        viewModel = SearchViewModel(getUseCase, filterUseCase)
    }

    @Test
    fun `getSearchResults - on Success Receive - should return success state`() = runTest {
        //given
        coEvery { getUseCase.getSearchResults() } returns dummySuccessResponse

        //when
        viewModel.getSearchResults()

        //then
        assertEquals(
            (viewModel.state.value as SearchResultState.Success).searchResults,
            dummySuccessState.searchResults
        )
    }

    @Test
    fun `getSearchResults - on Failure Receive - should return failure state`() = runTest {
        //given
        coEvery { getUseCase.getSearchResults() } returns SearchResult.Error("")

        //when
        viewModel.getSearchResults()

        //then
        assertEquals(
            (viewModel.state.value as SearchResultState.Error).exception,
            ""
        )
    }
}