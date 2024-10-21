package com.example.musictify.domain

data class Carousel(
    val id: String,
    val title: String,
    val cards: List<CarouselCard>
)

data class CarouselCard(
    val id: String,
    val imageUrl: String,
    val caption: String,
    val associatedResult: SearchResult
)