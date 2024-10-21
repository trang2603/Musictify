package com.example.musictify.domain

data class PodcastShow(
    val id: String,
    val title: String,
    val imageUrl: String,
    val publisher: String,
    val descriptionHtml: String
) {
}