// for Popular and TopRated Movies
package com.example.themoviedb.data.model

data class Popular(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)