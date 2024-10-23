package com.example.musictify.data.remote.response

import com.example.musictify.data.utils.MapperImageSize
import com.example.musictify.data.utils.getImageResponseForImageSize
import com.example.musictify.domain.PodcastShow
import com.fasterxml.jackson.annotation.JsonProperty

data class ShowResponse(
    val id: String,
    val name: String,
    val publisher: String,
    @JsonProperty("html_description") val descriptionHtml: String,
    val images: List<ImageResponse>
) {
}

fun ShowResponse.toPodcastShow() = PodcastShow(
    id = id,
    title = name,
    imageUrl = images.getImageResponseForImageSize(MapperImageSize.LARGE).url,
    publisher = publisher,
    descriptionHtml = descriptionHtml
)