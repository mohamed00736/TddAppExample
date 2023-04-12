package com.hacine.med.tddappexample.data.network.state


sealed class Resource<T>{
    class Loading<T>: Resource<T>()
    data class Failure<T>(val message: String): Resource<T>()
    data class Success<T>(val data: T): Resource<T>()
}