package com.example.musictify.domain

data class FeaturedPlaylists(
    val playlistsDescription: String,
    val playlists: List<SearchResult.PlaylistResult>
) {
}