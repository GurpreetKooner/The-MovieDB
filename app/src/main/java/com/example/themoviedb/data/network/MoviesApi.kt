package com.example.themoviedb.data.network

import com.example.themoviedb.data.model.NowPlaying
import com.example.themoviedb.data.model.Popular
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface MoviesApi {

    @GET("movie/now_playing?api_key=a01b3ea3824e74e88149e0f4e9818855&page=1&region=IN")
    suspend fun getNowPlayingMovies(): Response<NowPlaying>

    @GET("movie/popular?api_key=a01b3ea3824e74e88149e0f4e9818855&page=1&region=IN")
    suspend fun getPopularMovies(): Response<Popular>

    @GET("movie/top_rated?api_key=a01b3ea3824e74e88149e0f4e9818855&page=1&region=IN")
    suspend fun getTopRatedMovies(): Response<Popular>

    companion object {
        operator fun invoke(): MoviesApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://api.themoviedb.org/3/")
                .build()
                .create(MoviesApi::class.java)
        }
    }
}