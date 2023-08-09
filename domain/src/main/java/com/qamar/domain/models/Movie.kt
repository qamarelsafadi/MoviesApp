package com.qamar.domain.models

import androidx.annotation.Keep

@Keep
data class Movie(
    val id: Int = 0,
    val overview: String = "",
    val posterPath: String = "",
    val releaseDate: String = "",
    val title: String = "",
) {
    companion object {
        val previewData: List<Movie> = listOf(
            Movie(
                id = 8067,
                overview = "ei",
                posterPath = "nostra",
                releaseDate = "sententiae",
                title = "nisl"
            ),
            Movie(
                id = 8027,
                overview = "ei",
                posterPath = "nostra",
                releaseDate = "sententiae",
                title = "nisl"
            ),
            Movie(
                id = 8037,
                overview = "ei",
                posterPath = "nostra",
                releaseDate = "sententiae",
                title = "nisl"
            ),
            Movie(
                id = 8047,
                overview = "ei",
                posterPath = "nostra",
                releaseDate = "sententiae",
                title = "nisl"
            )
        )
    }
}