package com.example.musictify.data.remote.musicservice

object SpotifyEndPoints {
    const val API_TOKEN_ENDPOINT = "api/token"
    const val ALBUM_ENDPOINT = "v1/albums/{id}"
    const val ALBUM_TRACKS_ENDPOINT = "v1/albums/{id}/tracks"
    const val NEW_RELEASE_ENDPOINT = "v1/browse/new-releases"
    const val ARTIST_ENDPOINT = "v1/artists/{id}"
    const val ARTIST_ALBUMS_ENDPOINT = "v1/artists/{id}/albums"
    const val ARTIST_TOP_TRACKS_ENDPOINT = "v1/artists/{id}/top-tracks"
    const val BROWSE_CATEGORIES_ENDPOINT = "v1/browse/categories"
    const val EPISODE_ENDPOINT = "v1/episodes/{id}"
    const val REMOVE_PLAYLIST_ITEMS_ENDPOINT = "v1/playlists/{playlist_id}/tracks"
    const val FEATURED_PLAYLISTS_ENDPOINT = "v1/browse/featured-playlists"
    const val CATEGORY_PLAYLISTS_ENDPOINT = "1/browse/categories/{category_id}/playlists"
    const val SEARCH_ENDPOINT = "v1/search"
    const val SHOW_ENDPOINT = "v1/shows/{id}"
    const val SHOW_EPISODES_ENDPOINT = "v1/shows/{id}/episodes"
}