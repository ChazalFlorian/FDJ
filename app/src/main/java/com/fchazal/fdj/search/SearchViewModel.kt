package com.fchazal.fdj.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fchazal.fdj.search.domain.interactor.FilterLeagueUseCase
import com.fchazal.fdj.search.domain.interactor.GetLeagueUseCase
import com.fchazal.fdj.search.domain.model.LeagueResult
import com.fchazal.fdj.search.presentation.model.LeagueBlockUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class SearchLeagueState {
    data object Loading : SearchLeagueState()

    class Error(val exception: String) : SearchLeagueState()

    class Success(val searchResults: List<LeagueBlockUI>) : SearchLeagueState()
}

class SearchViewModel(
    private val getLeagueUseCase: GetLeagueUseCase,
    private val filterLeagueUseCase: FilterLeagueUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<SearchLeagueState>(SearchLeagueState.Loading)
    private val _allLeaguesState = MutableStateFlow<SearchLeagueState>(SearchLeagueState.Loading)
    val state: StateFlow<SearchLeagueState> = _allLeaguesState.asStateFlow()

    suspend fun getLeagues() {
        viewModelScope.launch {
            when (val result = getLeagueUseCase.getLeagues()) {
                is LeagueResult.Error -> {
                    _allLeaguesState.emit(SearchLeagueState.Error(result.error))
                }

                is LeagueResult.Success -> {
                    _state.emit(SearchLeagueState.Success(result.leagueList))
                    _allLeaguesState.emit(SearchLeagueState.Success(result.leagueList))
                }
            }
        }
    }

    fun filterLeagues(query : String) {
        if(state.value is SearchLeagueState.Success) {
            viewModelScope.launch {
                when(val result = filterLeagueUseCase.filterLeagues(query, (_state.value as SearchLeagueState.Success).searchResults)) {
                    is LeagueResult.Error -> {
                        _allLeaguesState.emit(SearchLeagueState.Error(result.error))
                    }
                    is LeagueResult.Success -> {
                        _allLeaguesState.emit(SearchLeagueState.Success(result.leagueList))
                    }
                }
            }
        }
    }
}