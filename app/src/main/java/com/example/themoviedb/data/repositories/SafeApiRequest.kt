package com.example.themoviedb.data.repositories

import android.util.Log
import retrofit2.Response

abstract class SafeApiRequest {
    suspend fun <T : Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful) {
//            Log.e("zzzzz",response.body().toString())
            return response.body()!!
        } else {
            return throw ApiException(response.code().toString())
        }
    }
}