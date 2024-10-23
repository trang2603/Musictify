package com.example.musictify.data.repositories.tokenrepository

import com.example.musictify.data.remote.token.BearerToken
import com.example.musictify.domain.ApiErrorType
import com.example.musictify.domain.toApiErrorType
import com.fasterxml.jackson.core.JacksonException
import retrofit2.HttpException
import java.io.IOException

suspend fun <R> TokenRepository.withValidToken(
    block: suspend (BearerToken) -> R
): FetchedResource<R, ApiErrorType> =
    try {
        FetchedResource.Success(block(fetchValidToken()))
    }catch (httpException: HttpException) {
        FetchedResource.Failure(httpException.toApiErrorType())
    }catch (ioException: IOException) {
        FetchedResource.Failure (
            if(ioException is JacksonException) ApiErrorType.DESERIALIZATION_ERROR
            else ApiErrorType.NETWORK_CONNECTION_FAILURE
        )
    }