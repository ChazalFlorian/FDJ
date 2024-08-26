package com.fchazal.fdj.league

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fchazal.fdj.league.domain.interactor.GetLeaguesUseCase
import com.fchazal.fdj.league.domain.model.LeagueResult
import com.fchazal.fdj.league.presentation.model.LeagueItemBlockUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class LeagueResultState {
    data object Loading : LeagueResultState()

    class Error(val exception: String) : LeagueResultState()

    class Success(val searchResults: List<LeagueItemBlockUI>) : LeagueResultState()
}

class LeagueViewModel(
    private val useCase: GetLeaguesUseCase,
) : ViewModel() {

    private val _state = MutableStateFlow<LeagueResultState>(LeagueResultState.Loading)
    val state: StateFlow<LeagueResultState> = _state.asStateFlow()

    suspend fun getLeagues(query: String) {
        viewModelScope.launch {
            when (val result = useCase.getLeagues(query)) {
                is LeagueResult.Error -> {
                    _state.emit(LeagueResultState.Error(result.error))
                }

                is LeagueResult.Success -> {
                    _state.emit(LeagueResultState.Success(result.searchList))
                }
            }
        }
    }
}