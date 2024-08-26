package com.fchazal.fdj.league.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fchazal.fdj.league.LeagueResultState

@Composable
fun LeagueScreen(state: LeagueResultState) {

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        when (state) {
            is LeagueResultState.Error -> {
                Text(text = "An error was thrown, please refresh view or restart app")
            }

            LeagueResultState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(42.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                )
            }

            is LeagueResultState.Success -> {
                LeagueScreenContent(state.searchResults)
            }
        }
    }
}