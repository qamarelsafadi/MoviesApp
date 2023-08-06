package com.qamar.domain.models

import androidx.annotation.Keep

@Keep
data class Movie(
    val id: Int = 0,
    val overview: String = "",
    val posterPath: String = "",
    val releaseDate: String = "",
    val title: String = "",
)