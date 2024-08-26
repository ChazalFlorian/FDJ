package com.fchazal.fdj.league

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import com.fchazal.fdj.league.presentation.view.LeagueScreen
import com.fchazal.fdj.ui.theme.FDJTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LeagueFragment : Fragment() {

    private val viewModel: LeagueViewModel by viewModel()

    override fun onResume() {
        super.onResume()
        arguments?.getString(PARAMETER, "")?.let {
            CoroutineScope(Dispatchers.IO).launch {
                viewModel.getLeagues(it)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                FDJTheme {
                    LeagueScreen(viewModel.state.collectAsState().value)
                }
            }
        }
    }

    companion object {
        fun getInstance(searchParameter: String): LeagueFragment {
            val fragment = LeagueFragment()
            val bundle = Bundle()
            bundle.putString(PARAMETER, searchParameter)
            fragment.arguments = bundle
            return fragment
        }

        private const val PARAMETER = "PARAMETER"
    }
}