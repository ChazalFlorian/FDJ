package com.fchazal.fdj.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fchazal.fdj.search.domain.interactor.FilterSearchUseCase
import com.fchazal.fdj.search.domain.interactor.GetSearchUseCase
import com.fchazal.fdj.search.domain.model.SearchResult
import com.fchazal.fdj.search.presentation.model.SearchItemBlockUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class SearchResultState {
    data object Loading : SearchResultState()

    class Error(val exception: String) : SearchResultState()

    class Success(val searchResults: List<SearchItemBlockUI>) : SearchResultState()
}

class SearchViewModel(
    private val getSearchUseCase: GetSearchUseCase,
    private val filterSearchUseCase: FilterSearchUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<SearchResultState>(SearchResultState.Loading)
    private val _allSearchResultsState = MutableStateFlow<SearchResultState>(SearchResultState.Loading)
    val state: StateFlow<SearchResultState> = _allSearchResultsState.asStateFlow()

    suspend fun getSearchResults() {
        viewModelScope.launch {
            when (val result = getSearchUseCase.getSearchResults()) {
                is SearchResult.Error -> {
                    _allSearchResultsState.emit(SearchResultState.Error(result.error))
                }

                is SearchResult.Success -> {
                    _state.emit(SearchResultState.Success(result.searchList))
                    _allSearchResultsState.emit(SearchResultState.Success(result.searchList))
                }
            }
        }
    }

    fun filterSearchResults(query : String) {
        if(state.value is SearchResultState.Success) {
            viewModelScope.launch {
                when(val result = filterSearchUseCase.filterSearch(query, (_state.value as SearchResultState.Success).searchResults)) {
                    is SearchResult.Error -> {
                        _allSearchResultsState.emit(SearchResultState.Error(result.error))
                    }
                    is SearchResult.Success -> {
                        _allSearchResultsState.emit(SearchResultState.Success(result.searchList))
                    }
                }
            }
        }
    }
}