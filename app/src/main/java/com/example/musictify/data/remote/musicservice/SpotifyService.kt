package com.example.musictify.data.remote.musicservice

import com.example.musictify.data.remote.token.BearerToken
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface SpotifyService {
    @GET(SpotifyEndPoints.ARTIST_ENDPOINT)
    suspend fun getArtistInfoWithId(
        @Path("id") artistId: String,
        @Header("Authorization") token: BearerToken
    ):
}