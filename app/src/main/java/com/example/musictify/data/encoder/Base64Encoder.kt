package com.example.musictify.data.encoder

interface Base64Encoder {
    fun encoderToString(input: ByteArray): String
}