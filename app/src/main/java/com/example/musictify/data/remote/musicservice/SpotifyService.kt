package com.example.musictify.data.remote.musicservice

import com.example.musictify.data.remote.response.ArtistResponse
import com.example.musictify.data.remote.token.BearerToken
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface SpotifyService {
    @GET(SpotifyEndPoints.ARTIST_ENDPOINT)
    suspend fun getArtistInfoWithId(
        @Path("id") artistId: String,
        @Header("Authorization") token: BearerToken
    ): ArtistResponse

    @GET(SpotifyEndPoints.ARTIST_ALBUMS_ENDPOINT)
    suspend fun getAlbumsOfArtistWithId(
        @Path("id") artistId: String,
        @Query("market") market: String,
        @Header("Authorization") token: BearerToken,
        @Query("limit") limit: Int = 20,
        @Query("offset") offset: Int = 0,
        @Query("include_groups") includeGroups: String? = null,
    ): Album
}