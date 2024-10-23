package com.example.musictify.domain

import android.content.Context
import java.time.Month

sealed class SearchResult {

    data class Album(
        val id: String,
        val name: String,
        val artists: String,
        val coverUrl: String,
        val releaseYear: String
    ) : SearchResult()

    data class PlaylistResult(
        val id: String,
        val title: String,
        val owner: String,
        val trackCount: String,
        val imageUrl: String? = null
    ) : SearchResult()

    data class Artist(
        val id: String,
        val name: String,
        val imageUrl: String? = null
    ) : SearchResult()

    data class Track(
        val id: String,
        val name: String,
        val imageUrl: String,
        val artists: String,
        val streamUrl: String? = null,
    ) : SearchResult(), Streamable {
        override val streamInfo = StreamInfo(
            streamUrl = streamUrl,
            imageUrl = imageUrl,
            title = name,
            subtitle = artists
        )
    }

    data class Podcast(
        val id: String,
        val name: String,
        val publisher: String,
        val imageUrl: String
    ) : SearchResult()

    data class Episode(
        val id: String,
        val content: Content,
        val releaseDate: ReleaseDate,
        val duration: Duration
    ) : SearchResult() {
        data class Content(
            val title: String,
            val description: String,
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
}

fun SearchResult.Episode.getFormattedDateAndDuration(context: Context): String =
    generateMusictifyDateAndDuration(

    )