package com.example.musictify.data.remote.response

import com.example.musictify.data.utils.MapperImageSize
import com.example.musictify.data.utils.getImageResponseForImageSize
import com.example.musictify.domain.SearchResult
import com.fasterxml.jackson.annotation.JsonProperty

data class AlbumInfoResponse(
    val id: String,
    val name: String,
    @JsonProperty("album_type") val albumType: String,
    val artists: List<ArtistResponse>,
    val images: List<ImageResponse>,
    @JsonProperty("release_date") val releaseDate: String,
    @JsonProperty("release_date_precision") val releaseDatePrecision: String,
    @JsonProperty("total_tracks") val totalTracks: Int,
    val type: String
) {
    data class ArtistResponse(
        val id: String, val name: String
    )
}

fun AlbumInfoResponse.mapToAlbumSearchResult() = SearchResult.Album(
    id = id,
    name = name,
    artists = artists.joinToString(", ") {it.name},
    coverUrl = images.getImageResponseForImageSize(MapperImageSize.LARGE).url,
    releaseYear = releaseDate.substring(0..3)
)