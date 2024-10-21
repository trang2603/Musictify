package com.example.musictify.domain

import retrofit2.HttpException


enum class ApiErrorType {
    INVALID_OR_EXPIRED_TOKEN,
    INVALID_OAUTH_REQUEST,
    INVALID_REQUEST,
    RATE_LIMIT_EXCEEDED,
    UNEXPECTED_ERROR,
    NETWORK_CONNECTION_FAILURE,
    RESOURCE_NOT_FOUND,
    DESERIALIZATION_ERROR
}

fun HttpException.toApiErrorType(): ApiErrorType =
    when(this.code()) {
        400 -> ApiErrorType.INVALID_REQUEST
        401 -> ApiErrorType.INVALID_OR_EXPIRED_TOKEN
        402 -> ApiErrorType.INVALID_OAUTH_REQUEST
        429 -> ApiErrorType.RATE_LIMIT_EXCEEDED
        404 -> ApiErrorType.RESOURCE_NOT_FOUND
        else -> ApiErrorType.UNEXPECTED_ERROR
    }