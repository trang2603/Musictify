package com.example.musictify.data.remote.response

import com.example.musictify.domain.FeaturedPlaylists
import com.fasterxml.jackson.annotation.JsonProperty

data class FeaturedPlaylistResponse(
    @JsonProperty("message") val description: String,
    val playlistItems: PlaylistItemsResponse
) {
    data class PlaylistItemsResponse(val items: List<PlaylistMetadataResponse>)
}

fun FeaturedPlaylistResponse.toDomainModel(): FeaturedPlaylists = FeaturedPlaylists(
    playlistsDescription = description,
    playlists = playlistItems.items.map { it.toSearchResult() }
)