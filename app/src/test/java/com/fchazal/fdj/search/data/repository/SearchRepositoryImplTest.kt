package com.fchazal.fdj.search.data.repository

import com.fchazal.fdj.search.data.datasource.SearchDataSource
import com.fchazal.fdj.search.data.dummySearchResponse
import com.fchazal.fdj.search.data.dummySuccessResponse
import com.fchazal.fdj.search.domain.model.SearchResult
import com.fchazal.fdj.search.domain.repository.SearchRepository
import com.fchazal.fdj.util.CoroutineTestRule
import io.mockk.MockKAnnotations.init
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchRepositoryImplTest {

    @get:Rule
    val coroutineTestRule: CoroutineTestRule = CoroutineTestRule()

    @MockK
    lateinit var dataSource: SearchDataSource
    private lateinit var searchRepository: SearchRepository
    private val errorMessage = "test"
    private val error = Throwable(errorMessage)

    @Before
    fun setUp() {
        init(this)
        searchRepository = SearchRepositoryImpl(dataSource)
    }

    @Test
    fun `getSearch - onSuccess - should return Success`() = runTest {
        //given
        coEvery { dataSource.getSearchResults() } returns Result.success(dummySearchResponse)

        //when
        searchRepository.getSearch()

        //then
        assertEquals(
            searchRepository.getSearch(), dummySuccessResponse
        )
    }

    @Test
    fun `getSearch - onFailure - should return Failure`() = runTest {
        //given
        coEvery { dataSource.getSearchResults() } returns Result.failure(error)

        //when
        searchRepository.getSearch()

        //then
        assertEquals(
            searchRepository.getSearch(), SearchResult.Error(
                errorMessage
            )
        )
    }
}