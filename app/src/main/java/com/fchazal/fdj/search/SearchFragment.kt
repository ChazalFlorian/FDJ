package com.fchazal.fdj.search

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.fchazal.fdj.search.presentation.view.SearchLeagueScreen
import com.fchazal.fdj.ui.theme.FDJTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment() : Fragment() {

    private val viewModel: SearchViewModel by viewModel()

    override fun onResume() {
        super.onResume()
        CoroutineScope(Dispatchers.IO).launch {
            viewModel.getSearchResults()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FDJTheme {

                    val query = remember { mutableStateOf("") }

                    Scaffold(
                        topBar = {
                            SearchBar(
                                query = query.value,
                                onQueryChange = {
                                    query.value = it
                                    CoroutineScope(Dispatchers.Main).launch {
                                        viewModel.filterSearchResults(it)
                                    }
                                },
                                onSearch = {
                                    query.value = it
                                    CoroutineScope(Dispatchers.IO).launch {
                                        viewModel.filterSearchResults(it)
                                    }
                                },
                                active = true,
                                onActiveChange = {},
                                modifier = Modifier
                                    .height(80.dp)
                                    .fillMaxWidth()
                            ) {

                            }
                        }
                    ) {
                        SearchLeagueScreen(
                            state = viewModel.state.collectAsState().value,
                            onSearchItemClick = {
                                onSearchItemClick(it)
                            }
                        )
                    }
                }
            }
        }
    }

    private fun onSearchItemClick(itemId: String) {
        parentFragmentManager.commit {
            addToBackStack(null)
            //TODO
            // replace(
            //     R.id.main_layout,
            //     DetailLeagueFragment().apply {
            //         arguments = DetailLeagueParameter(leagueId).asBundle()
            //     }
            // )
        }
    }
}