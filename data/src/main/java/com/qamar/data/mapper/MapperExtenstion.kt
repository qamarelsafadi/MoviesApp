package com.qamar.data.mapper

import com.qamar.data.local.entity.MovieEntity
import com.qamar.data.remote.model.MovieModel
import com.qamar.domain.models.Movie

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
        this.image,
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

fun Movie.mapToEntity(): MovieEntity {
    return MovieEntity(
        this.id,
        this.overview,
        this.posterPath,
        this.releaseDate,
        this.title
    )
}