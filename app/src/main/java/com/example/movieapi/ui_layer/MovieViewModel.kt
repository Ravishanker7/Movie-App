package com.example.movieapi.ui_layer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieapi.common.Resource
import com.example.movieapi.data.MovieRepositery
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(private val movieRepositery:MovieRepositery) :ViewModel() {

    val movieList= mutableStateOf(MoviestateHolder())

    init {
        movieList.value= MoviestateHolder(isLoading = true)
        getMovieList()
    }
    fun getMovieList()=viewModelScope.launch ( Dispatchers.IO ){
        when(val  result=movieRepositery.getMovieList()){
            is Resource.success->{
                movieList.value= MoviestateHolder(data = result.data)
            }

            is Resource.error->{
                movieList.value= MoviestateHolder(error = result.message.toString())
            }
            else->{}

        }
    }
}