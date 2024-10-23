package com.example.musictify.data.remote.response

import com.example.musictify.data.utils.MapperImageSize
import com.example.musictify.data.utils.getImageResponseForImageSize
import com.example.musictify.domain.SearchResult
import com.fasterxml.jackson.annotation.JsonProperty

class AlbumResponse(
    val id: String,
    val name: String,
    @JsonProperty("album_type") val albumType: String,
    val artists: List<ArtistRepoeOptionalFiels>,
    val images: List<ImageResponse>,
    @JsonProperty("release_date") val releaseDate: String,
    @JsonProperty("release_date_precision") val releaseDatePrecision: String,
    @JsonProperty("total_tracks") val totalTracks: Int,
    val tracks: TrackListResponse
) {

    data class TrackListResponse(@JsonProperty("items") val value: List<TrackResponse>)

    data class TrackResponse(
        val id: String,
        val name: String,
        @JsonProperty("preview_url") val previewUrl: String?,
        @JsonProperty("is_playable") val isPlayable: Boolean,
        val explicit: Boolean,
        @JsonProperty("duration_ms") val durationInMillis: Int
    )

    data class ArtistRepoeOptionalFiels(
        val id: String,
        val name: String,
        val images: List<ImageResponse>?,
        val followers: ArtistResponse.Followers?
    )
}

fun AlbumResponse.asAlbumSearchResult() = SearchResult.Album(
    id = id,
    name = name,
    artists = artists.joinToString(", ") {it.name},
    releaseYear = releaseDate,
    coverUrl = images.getImageResponseForImageSize(MapperImageSize.LARGE).url
)

fun AlbumResponse.toTrackSearchResults(): List<SearchResult.Track> =
    tracks.value.map { track ->
        track.toTrackSearchResult(
            albumArtImageUrlString = images.getImageResponseForImageSize(MapperImageSize.LARGE).url,
            albumArtistsString = artists.joinToString(", ") {it.name}
        )
    }

fun AlbumResponse.TrackResponse.toTrackSearchResult(
    albumArtImageUrlString: String,
    albumArtistsString: String
) = SearchResult.Track(
    id = id,
    name = name,
    imageUrl = albumArtImageUrlString,
    artists =  albumArtistsString,
    streamUrl = previewUrl
)