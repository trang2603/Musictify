package com.example.musictify.data.remote.token.manager

import com.example.musictify.data.remote.musicservice.SpotifyEndPoints
import com.example.musictify.data.remote.token.AccessTokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

const val defaultGrantType = "client_credentials"

interface TokenManager {
    @FormUrlEncoded
    @POST(SpotifyEndPoints.API_TOKEN_ENDPOINT)
    suspend fun getNewAccessToken(
        @Header("Authorization") secret: String,
        @Field("grant_type") grantType: String = defaultGrantType,
    ): AccessTokenResponse
}