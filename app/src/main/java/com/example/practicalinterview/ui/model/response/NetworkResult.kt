package com.example.practicalinterview.ui.model.response

sealed class NetworkResult<out T> {
    data class Success<T>(val data: T) : NetworkResult<T>()
    data class Error(val exception: Throwable, val message: String) : NetworkResult<Nothing>()
}
