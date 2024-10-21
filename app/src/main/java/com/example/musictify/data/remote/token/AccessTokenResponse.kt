package com.example.musictify.data.remote.token

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class AccessTokenResponse(
    @JsonProperty("access_token") val accessToken: String,
    @JsonProperty("expires_in") val secondsUntilExpiration: Int,
    @JsonProperty("token_type") val tokenType: String
)

fun AccessTokenResponse.toBearerToken() = BearerToken(
    token = accessToken,
    timeOfCreation = LocalDateTime.now(),
    secondsUntilExpiration = secondsUntilExpiration
)