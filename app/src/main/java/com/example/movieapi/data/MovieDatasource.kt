package com.example.movieapi.data

import com.example.movieapi.Network.ApiService

class MovieDatasource(private val apiService:ApiService) {

    suspend fun getMovieList()=apiService.getMovieList(apiKey = "2111af47f03fa600e3944d12c2d06de0")

}