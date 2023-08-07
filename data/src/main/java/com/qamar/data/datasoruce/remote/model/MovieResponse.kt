package com.qamar.data.datasoruce.remote.model


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieResponse(
    val page: Int = 0,
    @SerializedName("results")
    val movies: List<MovieModel> = listOf(),
    @SerializedName("total_pages")
    val totalPages: Int = 0,
    @SerializedName("total_results")
    val totalResults: Int = 0
)