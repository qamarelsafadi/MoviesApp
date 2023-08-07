package com.qamar.data.util

import com.qamar.data.datasoruce.local.entity.MovieEntity
import com.qamar.data.datasoruce.remote.model.MovieModel
import com.qamar.domain.models.Movie

fun List<MovieModel>.mapToEntity(): List<MovieEntity> {
    return this.map { movie ->
        MovieEntity(
            movie.id,
            movie.overview,
            movie.image,
            movie.releaseDate,
            movie.title
        )
    }
}

fun List<MovieEntity>.mapToModel(): List<Movie> {
    return this.map { movie ->
        Movie(
            movie.id,
            movie.overview,
            movie.posterImage,
            movie.releaseDate,
            movie.title
        )
    }
}

fun MovieModel.mapToUiModel(): Movie {
    return Movie(
        this.id,
        this.overview,
        this.posterPath,
        this.releaseDate,
        this.title
    )
}
fun MovieEntity.mapEntityToUiModel(): Movie {
    return Movie(
        this.id,
        this.overview,
        this.posterImage,
        this.releaseDate,
        this.title
    )
}