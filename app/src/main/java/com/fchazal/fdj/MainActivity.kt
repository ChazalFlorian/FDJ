package com.fchazal.fdj

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.commit
import com.fchazal.fdj.search.SearchFragment
import com.fchazal.fdj.ui.theme.FDJTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.commit {
            replace(R.id.main_layout, SearchFragment())
        }
    }
}