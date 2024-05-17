package com.example.movieapi.common

sealed class Resource<T>(val data:T?=null,val message:String?=null){

    class loading<T>(): Resource<T>()

    class success<T>(data: T?):Resource<T>(data = data)

    class error<T>(message: String?):Resource<T>(message = message)

}
