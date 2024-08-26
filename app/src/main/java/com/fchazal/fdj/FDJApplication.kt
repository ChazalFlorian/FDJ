package com.fchazal.fdj

import android.app.Application
import com.fchazal.fdj.inject.androidModule
import com.fchazal.fdj.inject.applicationModule
import com.fchazal.fdj.inject.dataSourceModule
import com.fchazal.fdj.inject.repositoryModule
import com.fchazal.fdj.inject.serviceModule
import com.fchazal.fdj.inject.useCaseModule
import com.fchazal.fdj.inject.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class FDJApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@FDJApplication)
            modules(
                androidModule,
                applicationModule,
                serviceModule,
                repositoryModule,
                dataSourceModule,
                viewModelModule,
                useCaseModule,
            )
        }
    }
}