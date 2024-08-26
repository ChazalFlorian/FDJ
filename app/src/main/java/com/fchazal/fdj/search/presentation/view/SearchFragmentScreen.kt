package com.fchazal.fdj.search.presentation.view

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fchazal.fdj.search.SearchLeagueState

@Composable
fun SearchLeagueScreen(
    state: SearchLeagueState,
    onLeagueClick: (String) -> Unit
    ) {
    when(state) {
        is SearchLeagueState.Error -> {
            Text(text = "An error was thrown, please refresh view or restart app")
        }
        SearchLeagueState.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(42.dp)
                    .fillMaxWidth()
                    .fillMaxHeight()
            )
        }
        is SearchLeagueState.Success -> {
            LeagueList(leagues = state.searchResults, onLeagueClick = onLeagueClick)
        }
    }
}