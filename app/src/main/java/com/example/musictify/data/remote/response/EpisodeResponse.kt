package com.example.musictify.data.remote.response

import com.example.musictify.data.utils.MapperImageSize
import com.example.musictify.data.utils.getFormattedEpisodeReleaseDateAndDuration
import com.example.musictify.data.utils.getImageResponseForImageSize
import com.example.musictify.domain.SearchResult
import com.fasterxml.jackson.annotation.JsonProperty

data class EpisodeResponse(
    val id: String,
    @JsonProperty("name") val title: String,
    val description: String,
    @JsonProperty("duration_ms") val durationMillis: Long,
    val images: List<ImageResponse>,
    @JsonProperty("release_date") val releaseDate: String
) {
}

fun EpisodeResponse.toSearchResult(): SearchResult.Episode {
    val contentInfo = SearchResult.Episode.Content(
        title = title,
        description = description,
        imageUrl = images.getImageResponseForImageSize(MapperImageSize.LARGE).url
    )

    val releaseDateAndDuration = getFormattedEpisodeReleaseDateAndDuration(
        releaseDate = releaseDate,
        durationMillis = durationMillis
    )

    val episodeDateInfo = SearchResult.Episode.ReleaseDate(
        month = releaseDateAndDuration.month,
        day = releaseDateAndDuration.day,
        year = releaseDateAndDuration.year
    )

    val episodeDurationInfo = SearchResult.Episode.Duration(
        hours = releaseDateAndDuration.hours,
        minutes = releaseDateAndDuration.minutes
    )
    return SearchResult.Episode(
        id = id,
        content = contentInfo,
        releaseDate = episodeDateInfo,
        duration = episodeDurationInfo
    )

}