package com.fchazal.fdj.league.presentation.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.bumptech.glide.integration.compose.placeholder
import com.fchazal.fdj.league.presentation.model.LeagueItemBlockUI

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun LeagueScreenContent(leagues: List<LeagueItemBlockUI>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(leagues) { team ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                GlideImage(
                    model = team.logoUrl,
                    contentDescription = team.description,
                    modifier = Modifier
                        .fillMaxWidth(),
                    loading = placeholder { CircularProgressIndicator() }
                )
            }
        }
    }
}