package com.example.movieapi.ui_layer

import com.example.movieapi.model.Movie

data class MoviestateHolder(
    val isLoading:Boolean=false,
    val data:List<Movie>?=null,
    val error:String=""
)
