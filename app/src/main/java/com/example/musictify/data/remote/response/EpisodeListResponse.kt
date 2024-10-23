package com.example.musictify.data.remote.response

import com.fasterxml.jackson.annotation.JsonProperty

data class EpisodeListResponse(val items: List<EpisodeItemResponse>) {
    data class EpisodeItemResponse(
        val id: String,
        @JsonProperty("name") val title: String
    )
}