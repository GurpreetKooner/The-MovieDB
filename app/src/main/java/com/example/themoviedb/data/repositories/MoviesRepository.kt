package com.example.themoviedb.data.repositories

import com.example.themoviedb.data.network.MoviesApi

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {
    suspend fun getNowPlayingMovies() = apiRequest { api.getNowPlayingMovies() }
    suspend fun getPopular() = apiRequest { api.getPopularMovies() }
    suspend fun getTopRated() = apiRequest { api.getTopRatedMovies() }
}