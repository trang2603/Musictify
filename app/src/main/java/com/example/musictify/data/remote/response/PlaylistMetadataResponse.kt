package com.example.musictify.data.remote.response

import com.example.musictify.domain.SearchResult
import com.fasterxml.jackson.annotation.JsonProperty

data class PlaylistMetadataResponse(
    val id: String,
    val name: String,
    val images: List<ImageResponse>,
    @JsonProperty("owner") val owner: Owner,
    @JsonProperty("tracks") val trackCount: TrackCount,
) {
    data class Owner(@JsonProperty("display_name") val displayName: String)
    data class TrackCount(@JsonProperty("total") val total: Int)
}

fun PlaylistMetadataResponse.toSearchResult() = SearchResult.PlaylistResult(
    id = id,
    title = name,
    owner = owner.displayName,
    imageUrl = images.firstOrNull()?.url,
    trackCount = trackCount.total.toString()
)