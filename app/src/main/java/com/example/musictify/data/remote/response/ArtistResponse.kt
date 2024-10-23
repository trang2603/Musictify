package com.example.musictify.data.remote.response

import com.example.musictify.data.utils.MapperImageSize
import com.example.musictify.data.utils.getImageResponseForImageSize
import com.example.musictify.domain.SearchResult

data class ArtistResponse(
    val id: String,
    val name: String,
    val images: List<ImageResponse>,
    val followers: Followers
) {
    data class Followers(val total: String)
}

fun ArtistResponse.toArtistSearchResult() = SearchResult.Artist(
    id = id,
    name = name,
    imageUrl = if(images.isEmpty()) null
    else if (images.size !=3) images.first().url
    else images.getImageResponseForImageSize(MapperImageSize.LARGE).url
)