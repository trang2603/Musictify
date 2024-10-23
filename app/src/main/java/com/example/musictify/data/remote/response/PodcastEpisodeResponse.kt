package com.example.musictify.data.remote.response

import com.example.musictify.data.utils.MapperImageSize
import com.example.musictify.data.utils.getFormattedEpisodeReleaseDateAndDuration
import com.example.musictify.data.utils.getImageResponseForImageSize
import com.example.musictify.domain.PodcastEpisodeDetails
import com.fasterxml.jackson.annotation.JsonProperty

data class PodcastEpisodeResponse(
    val id: String,
    @JsonProperty("name") val title: String,
    @JsonProperty("images") val images: List<ImageResponse>,
    val description: String,
    @JsonProperty("html_description") val descriptionHtml: String,
    @JsonProperty("duration_ms") val durationMillis: Long,
    @JsonProperty("release_date") val releaseDate: String,
    @JsonProperty("audio_preview_url") val previewUrl: String?,
    val podcastShow: PodcastShowResponse
) {

    data class PodcastShowResponse(
        val id: String,
        val name: String,
        val image: List<ImageResponse>
    )
}

fun PodcastEpisodeResponse.toPodcastEpisode(): PodcastEpisodeDetails {
    val releaseDateAndDuration = getFormattedEpisodeReleaseDateAndDuration(
        releaseDate = releaseDate,
        durationMillis = durationMillis
    )

    val releaseDateInfo = PodcastEpisodeDetails.ReleaseDate(
        month = releaseDateAndDuration.month,
        day = releaseDateAndDuration.day,
        year = releaseDateAndDuration.year
    )

    val durationInfo = PodcastEpisodeDetails.Duration(
        hours = releaseDateAndDuration.hours,
        minutes = releaseDateAndDuration.minutes
    )

    return PodcastEpisodeDetails(
        id = id,
        title = title,
        imageUrl = images.getImageResponseForImageSize(MapperImageSize.LARGE).url,
        description = description,
        descriptionHtml = descriptionHtml,
        previewUrl = previewUrl,
        releaseDate = releaseDateInfo,
        duration = durationInfo,
        showInfo = PodcastEpisodeDetails.ShowInfo(
            id = podcastShow.id,
            name = podcastShow.name,
            imageUrl = podcastShow.image.getImageResponseForImageSize(MapperImageSize.LARGE).url
        )
    )
}