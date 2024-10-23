package com.example.musictify.data.repositories.tokenrepository

import com.example.musictify.data.encoder.Base64Encoder
import com.example.musictify.data.remote.token.BearerToken
import com.example.musictify.data.remote.token.getSpotifyClientSecret
import com.example.musictify.data.remote.token.isExpired
import com.example.musictify.data.remote.token.manager.TokenManager
import com.example.musictify.data.remote.token.toBearerToken
import javax.inject.Inject

class TokenRepositoryImp @Inject constructor(
    private val tokenManager: TokenManager,
    private val base64Encoder: Base64Encoder
): TokenRepository {
    private var token: BearerToken? = null

    override suspend fun fetchValidToken(): BearerToken {
        if (token == null || token?.isExpired==true) getAndAssignToken()
        return token!!
    }

    private suspend fun getAndAssignToken() {
        val clientSecret = getSpotifyClientSecret(base64Encoder)
        token = tokenManager
            .getNewAccessToken(clientSecret)
            .toBearerToken()
    }
}