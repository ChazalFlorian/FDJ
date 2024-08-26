package com.fchazal.fdj.inject

import android.util.Log
import com.fchazal.fdj.league.data.datasource.LeagueService
import com.fchazal.fdj.search.data.datasource.SearchService
import com.skydoves.retrofit.adapters.result.ResultCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val applicationModule = module {

    factory {

        val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Log.d("DEBUG", message) }
            .apply { level = HttpLoggingInterceptor.Level.BODY }

        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder().baseUrl("https://www.thesportsdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .client(okHttpBuilder)
            .build()

        retrofit.create(SearchService::class.java)
    }

    factory {

        val httpLoggingInterceptor = HttpLoggingInterceptor { message -> Log.d("DEBUG", message) }
            .apply { level = HttpLoggingInterceptor.Level.BODY }

        val okHttpBuilder = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()

        val retrofit = Retrofit.Builder().baseUrl("https://www.thesportsdb.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(ResultCallAdapterFactory.create())
            .client(okHttpBuilder)
            .build()

        retrofit.create(LeagueService::class.java)
    }
}