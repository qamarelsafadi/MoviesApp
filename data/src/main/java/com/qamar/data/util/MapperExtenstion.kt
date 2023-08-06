package com.qamar.data.util

import com.qamar.data.datasoruce.local.entity.MovieEntity
import com.qamar.domain.models.Movie

fun List<Movie>.map(): List<MovieEntity> {
    return this.map { movie ->
        MovieEntity(
            movie.id,
            movie.overview,
            movie.posterPath,
            movie.releaseDate,
            movie.title
        )
    }
}

fun List<MovieEntity>.map(): List<Movie> {
    return this.map { movie ->
        Movie(
            movie.id,
            movie.overview,
            movie.posterPath,
            movie.releaseDate,
            movie.title
        )
    }
}