package com.fchazal.fdj.search.domain.model

import com.fchazal.fdj.search.presentation.model.SearchItemBlockUI

sealed class SearchResult {
    data class Success(val searchList: List<SearchItemBlockUI>) : SearchResult()
    data class Error(val error: String) : SearchResult()
}