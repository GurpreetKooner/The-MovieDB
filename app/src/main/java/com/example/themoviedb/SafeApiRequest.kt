package com.example.themoviedb
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        return if (response.isSuccessful) {
            response.body()!!
        } else {
            throw ApiException(response.code().toString())
        }
    }
}