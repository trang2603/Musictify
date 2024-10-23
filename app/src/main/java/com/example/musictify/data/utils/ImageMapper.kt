package com.example.musictify.data.utils

import com.example.musictify.data.remote.response.ImageResponse

fun List<ImageResponse>.getImageResponseForImageSize(imageSize: MapperImageSize): ImageResponse{
    if(this.isEmpty()) throw IllegalStateException("The list of images is empty")
    if(this.size < 3) return this.last()
    return when (imageSize) {
        MapperImageSize.SMALL -> this[0]
        MapperImageSize.MEDIUM -> this[1]
        MapperImageSize.LARGE -> this[2]
    }
}