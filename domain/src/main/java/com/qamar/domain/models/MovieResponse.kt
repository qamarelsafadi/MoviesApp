package com.qamar.domain.models


import androidx.annotation.Keep

@Keep
data class MovieResponse(
    val page: Int = 0,
    val movies: List<Movie> = listOf(),
    val totalPages: Int = 0,
    val totalResults: Int = 0
)