package com.example.musictify.data.remote.response

import com.example.musictify.data.utils.MapperImageSize
import com.example.musictify.data.utils.getFormattedEpisodeReleaseDateAndDuration
import com.example.musictify.data.utils.getImageResponseForImageSize
import com.example.musictify.domain.PodcastEpisodeDetails
import com.example.musictify.domain.PodcastShow
import com.fasterxml.jackson.annotation.JsonProperty

data class EpisodeListResponse(val items: List<EpisodeItemResponse>) {
    data class EpisodeItemResponse(
        val id: String,
        @JsonProperty("name") val title: String,
        val description: String,
        @JsonProperty("html_description") val descriptionHtml: String,
        @JsonProperty("duration_ms") val durationMillis: Long,
        val images: List<ImageResponse>,
        @JsonProperty("release_date") val releaseDate: String,
        @JsonProperty("audio_preview_url") val previewUrl: String?
    )
}

fun EpisodeListResponse.EpisodeItemResponse.toPodcastEpisode(podcastShow: ShowResponse): PodcastEpisodeDetails {
    val episodeDateAndDuration = getFormattedEpisodeReleaseDateAndDuration(
        releaseDate = releaseDate,
        durationMillis = durationMillis
    )
    val releaseDateInfo = PodcastEpisodeDetails.ReleaseDate(
        month = episodeDateAndDuration.month,
        day = episodeDateAndDuration.day,
        year = episodeDateAndDuration.year
    )
    val durationInfo = PodcastEpisodeDetails.Duration(
        hours = episodeDateAndDuration.hours,
        minutes = episodeDateAndDuration.minutes
    )
    val podcastInfo = PodcastEpisodeDetails.ShowInfo(
        id = podcastShow.id,
        name = podcastShow.name,
        imageUrl = podcastShow.images.getImageResponseForImageSize(MapperImageSize.LARGE).url
    )
    return PodcastEpisodeDetails(
        id = id,
        title = title,
        description = description,
        imageUrl = images.getImageResponseForImageSize(MapperImageSize.LARGE).url,
        descriptionHtml = descriptionHtml,
        previewUrl = previewUrl,
        releaseDate = releaseDateInfo,
        duration = durationInfo,
        showInfo = podcastInfo
    )
}