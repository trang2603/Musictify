package com.example.musictify.data.remote.token

import java.time.LocalDateTime

data class BearerToken(
    private val token: String,
    val timeOfCreation: LocalDateTime,
    val secondsUntilExpiration: Int
) {
    val value get() = "Bearer $token"
    override fun toString(): String = "Bearer $token"
}

val BearerToken.isExpired: Boolean
    get() {
        val timeOfExpiration = timeOfCreation.plusSeconds(secondsUntilExpiration.toLong())
        return LocalDateTime.now() > timeOfExpiration
    }
