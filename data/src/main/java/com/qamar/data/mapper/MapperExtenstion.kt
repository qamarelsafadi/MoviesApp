package com.qamar.data.mapper

import com.qamar.data.local.entity.MovieEntity
import com.qamar.data.remote.model.MovieModel
import com.qamar.data.remote.model.MovieResponse
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

fun MovieResponse.mapToDomainResponse(): com.qamar.domain.models.MovieResponse {
    return com.qamar.domain.models.MovieResponse(
        page = this.page,
        movies = this.movies.map {
            Movie(
                it.id,
                it.overview,
                it.posterPath,
                it.releaseDate,
                it.title
            )
        },
        totalPages = this.totalPages,
        totalResults = this.totalResults

    )
}