package com.qamar.data.mapper

import com.qamar.data.local.entity.MovieEntity
import com.qamar.data.remote.model.MovieModel
import com.qamar.domain.models.Movie


fun MovieModel.mapToEntity(): MovieEntity {
    return MovieEntity(
        this.id,
        this.overview,
        this.image,
        this.releaseDate,
        this.title
    )
}
fun MovieModel.mapToModel(): Movie {
    return Movie(
        this.id,
        this.overview,
        this.image,
        this.releaseDate,
        this.title
    )
}

fun MovieEntity.mapEntityToModel(): Movie {
    return Movie(
        this.id,
        this.overview,
        this.posterImage,
        this.releaseDate,
        this.title
    )
}