package com.example.themoviedb

class MoviesRepository(
    private val api: MoviesApi
) : SafeApiRequest() {
    suspend fun getNowPlayingMovies() = apiRequest { api.getNowPlayingMovies() }
}