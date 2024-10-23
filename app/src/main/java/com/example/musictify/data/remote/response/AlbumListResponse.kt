package com.example.musictify.data.remote.response

import com.fasterxml.jackson.annotation.JsonProperty

class AlbumListResponse(
    val items: List<AlbumInfoResponse>,
    val limit: Int,
    @JsonProperty("next") val nextPageUrl: String,
    val offset: Int,
    @JsonProperty("previous") val previousPageUrl: String?,
    @JsonProperty("total") val totalItems: Int
) {
}

fun AlbumListResponse.asAlbumSearchResults() = items.map {
    it.mapToAlbumSearchResult()
}