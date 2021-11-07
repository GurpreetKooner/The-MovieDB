// for NowPlaying and Upcoming Movies
package com.example.themoviedb.data.model

data class NowPlaying(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)