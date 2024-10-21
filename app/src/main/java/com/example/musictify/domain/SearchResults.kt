package com.example.musictify.domain

import com.example.musictify.domain.SearchResult.*

data class SearchResults(
    val tracks: List<Track>,
    val albums: List<Album>,
    val artists: List<Artist>,
    val playlists: List<PlaylistResult>,
    val shows: List<PodcastShow>,
    val episode: List<Episode>
)

fun emptySearchResults() = SearchResults(
    tracks = emptyList(),
    albums = emptyList(),
    artists = emptyList(),
    playlists = emptyList(),
    shows = emptyList(),
    episode = emptyList()
)