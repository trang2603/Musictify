package com.example.musictify.domain

data class CategoryPlaylists(
    val categoryId: String,
    val categoryName: String,
    val associatedPlaylists: List<SearchResult.PlaylistResult>
)

fun CategoryPlaylists.toCarouselFromPlaylists(): Carousel = associatedPlaylists.map {
    CarouselCard(
        id = it.id,
        imageUrl = it.imageUrl ?: "",
        caption = it.title,
        associatedResult = it
    )
}.let {
    Carousel(
        id = categoryId,
        title = categoryName,
        cards = it
    )
}