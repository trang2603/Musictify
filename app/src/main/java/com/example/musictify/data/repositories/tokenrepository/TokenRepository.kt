package com.example.musictify.data.repositories.tokenrepository

import com.example.musictify.data.remote.token.BearerToken

interface TokenRepository {
    suspend fun fetchValidToken(): BearerToken
}