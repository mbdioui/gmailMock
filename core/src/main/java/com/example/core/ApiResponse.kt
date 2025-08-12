package com.example.core

import java.io.IOException

sealed class ApiResponse<out T> {
    object Loading : ApiResponse<Nothing>()
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val error: ErrorResponse) : ApiResponse<Nothing>()
}


sealed class ErrorResponse {
    data class NetworkError(
        val exception: IOException
    ) : ErrorResponse()

    data class ServorError(val code: Int, val message: String) : ErrorResponse()
    data class UnknownError(val throwable: Throwable) : ErrorResponse()
}