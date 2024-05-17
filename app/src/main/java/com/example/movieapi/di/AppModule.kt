package com.example.movieapi.di

import com.example.movieapi.Network.ApiService
import com.example.movieapi.data.MovieDatasource
import com.example.movieapi.data.MovieRepositery
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@InstallIn(SingletonComponent::class)
@Module
object AppModule {


    @Provides
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideDataSource(apiService:ApiService):MovieDatasource{
        return MovieDatasource(apiService)
    }

    @Provides
    fun provideMovieRepositery(datasource: MovieDatasource):MovieRepositery{
        return MovieRepositery(datasource)
    }
}