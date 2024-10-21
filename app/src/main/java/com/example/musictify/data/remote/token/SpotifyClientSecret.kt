package com.example.musictify.data.remote.token

import com.example.musictify.BuildConfig
import com.example.musictify.data.encoder.Base64Encoder

fun getSpotifyClientSecret(base64Encoder: Base64Encoder): String {
    val clientId = BuildConfig.SPOTIFY_CLIENT_ID
    val clientSecret = BuildConfig.SPOTIFY_CLIENT_SECRET
    val encode = base64Encoder.encoderToString("$clientId:$clientSecret".toByteArray())
    return "Basic $encode"
}