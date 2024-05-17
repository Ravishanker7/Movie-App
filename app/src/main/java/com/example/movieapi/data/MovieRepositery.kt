package com.example.movieapi.data

import com.example.movieapi.model.Movie
import com.example.movieapi.common.Resource


class MovieRepositery(private val movieDatasource:MovieDatasource) {

    suspend fun getMovieList():Resource<List<Movie>>{
        return try {
            Resource.success(data=movieDatasource.getMovieList().results)
        }catch (e:Exception){
            Resource.error(message = e.message.toString())
        }
    }
}