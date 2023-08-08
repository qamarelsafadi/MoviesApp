package com.qamar.data.remote.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class MovieModel(
    val id: Int = 0,
    val overview: String = "",
    @SerializedName("poster_path")
    val posterPath: String = "",
    @SerializedName("release_date")
    val releaseDate: String = "",
    val title: String = "",
){
    val image: String
        get() = "https://image.tmdb.org/t/p/original${posterPath}"

}