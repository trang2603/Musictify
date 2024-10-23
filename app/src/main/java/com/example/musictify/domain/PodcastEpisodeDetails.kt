package com.example.musictify.domain

import android.content.Context

data class PodcastEpisodeDetails(
    val id: String,
    val title: String,
    val imageUrl: String,
    val description: String,
    val descriptionHtml: String,
    val previewUrl: String?,
    val releaseDate: ReleaseDate,
    val duration: Duration,
    val showInfo: ShowInfo
) : Streamable {
    override val streamInfo = StreamInfo(
        streamUrl = previewUrl,
        imageUrl = showInfo.imageUrl,
        title = title,
        subtitle = showInfo.name
    )

    data class ShowInfo(
        val id: String,
        val name: String,
        val imageUrl: String
    )

    data class ReleaseDate(
        val month: String,
        val day: Int,
        val year: Int
    )

    data class Duration(
        val hours: Int,
        val minutes: Int
    )
}

fun PodcastEpisodeDetails.getFormattedDateAndDuration(context: Context): String =
    getFormattedEpisodeReleaseDateAndDuration()

fun PodcastEpisodeDetails?.isEqualIgnoreImageSize(other: PodcastEpisodeDetails?) : Boolean {
    if(other == null || this == null) return false
    if(this == other) return true
    val showInfoThis = this.showInfo.copy(imageUrl = "")
    val showInfoOther = other.showInfo.copy(imageUrl = "")
    val thisWithEmptyImageUrl = this.copy(showInfo = showInfoThis)
    val otherWithEmptyImageUrl = other.copy(showInfo = showInfoOther)
    return thisWithEmptyImageUrl == otherWithEmptyImageUrl
}