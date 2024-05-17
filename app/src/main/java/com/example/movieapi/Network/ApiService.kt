package com.example.movieapi.Network

import com.example.movieapi.model.MovieListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("3/movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey:String
    ):MovieListResponse
}