package com.fchazal.fdj.search.presentation.view

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.fchazal.fdj.search.presentation.model.LeagueBlocUI

@Composable
fun LeagueList(
    leagues: List<LeagueBlocUI>,
    onLeagueClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .padding(top = 80.dp)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        itemsIndexed(leagues) { key, league ->
            LeagueItem(
                league = league,
                isEven = key % 2 == 0,
                onLeagueClick = { onLeagueClick(league.league) })
        }
    }
}