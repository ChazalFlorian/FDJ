package com.fchazal.fdj.inject

import android.content.Context
import android.view.inputmethod.InputMethodManager
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val androidModule = module {
    single { androidContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager }
}